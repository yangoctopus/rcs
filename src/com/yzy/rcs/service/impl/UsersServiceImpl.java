package com.yzy.rcs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.UserRole;
import com.yzy.rcs.domain.Users;
import com.yzy.rcs.mapper.UserRoleMapper;
import com.yzy.rcs.mapper.UsersMapper;
import com.yzy.rcs.service.UsersService;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.UsersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UsersVo login(UsersVo usersVo) {
        // TODO Auto-generated method stub
        UsersVo vo = null;
        Users u=usersMapper.login(usersVo);
        System.out.println(usersVo.getLoginip());
        if(u!=null){
                vo = new UsersVo();
                BeanUtils.copyProperties(u, vo);
                vo.setLoginip(usersVo.getLoginip());
        }
        return vo;

    }

    @Override
    public DataGridModel<UsersVo> loadAll(UsersVo usersVo) {
        //执行分页操作
        Page page= PageHelper.startPage(usersVo.getPage(),usersVo.getRows());
        //查询数据库
        List<Users> ulist = usersMapper.loadAll(usersVo);
        List<UsersVo> uvolist = new ArrayList<>();
        for(Users u:ulist){
            UsersVo uvo=new UsersVo();
            BeanUtils.copyProperties(u,uvo);
            uvolist.add(uvo);
        }
        DataGridModel<UsersVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(uvolist);
        return dgm;
    }

    @Override
    public DataGridModel<UsersVo> findKey(UsersVo usersVo) {
        //执行分页操作
        Page page= PageHelper.startPage(usersVo.getPage(),usersVo.getRows());
        //查询数据库
        List<Users> ulist = usersMapper.findKey(usersVo.getKeywords());
        List<UsersVo> uvolist = new ArrayList<>();
        for(Users u:ulist){
            UsersVo uvo=new UsersVo();
            BeanUtils.copyProperties(u,uvo);
            uvolist.add(uvo);
        }
        DataGridModel<UsersVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(uvolist);
        return dgm;
    }

    private void delUr(UsersVo usersVo){
        //先删除中间表，断绝用户和角色的关系
        userRoleMapper.delUserRole(usersVo.getUsername());
        for(Integer rid:usersVo.getRid()){
            System.out.println(usersVo.getUsername());
            UserRole userRole=new UserRole();
            userRole.setRid(rid);
            userRole.setUsername(usersVo.getUsername());
            //添加中间表，建立角色关系
            userRoleMapper.saveUserRole(userRole);
        }
    }

    @Override
    public void saveUsers(UsersVo usersVo) {

        delUr(usersVo);
        usersMapper.saveUsers(usersVo);
    }

    @Override
    public void updateUsers(UsersVo usersVo) {
        //先删除中间表，断绝用户和角色的关系
        delUr(usersVo);
        usersMapper.updateUsers(usersVo);
    }

    @Override
    public void delUsers(UsersVo usersVo) {
        usersMapper.delUsers(usersVo);
    }

    @Override
    public List<Integer> loadUserRoleService(String username) {
        // TODO Auto-generated method stub
        return userRoleMapper.loadUserRole(username);
    }
}
