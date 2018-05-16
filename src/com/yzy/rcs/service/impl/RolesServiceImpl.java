package com.yzy.rcs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzy.rcs.domain.Roles;
import com.yzy.rcs.mapper.RolesMapper;
import com.yzy.rcs.service.RolesService;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RolesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;
    @Override
    public DataGridModel<RolesVo> findRolesKey(RolesVo rolesVo) {
        //执行分页操作
        Page page= PageHelper.startPage(rolesVo.getPage(),rolesVo.getRows());
        //查询数据库
        List<Roles> rlist = rolesMapper.findRolesKey(rolesVo);
        List<RolesVo> rvolist = new ArrayList<>();
        for(Roles r:rlist){
            RolesVo uvo=new RolesVo();
            BeanUtils.copyProperties(r,uvo);
            rvolist.add(uvo);
        }
        DataGridModel<RolesVo> dgm=new DataGridModel<>();
        dgm.setTotal((int) page.getTotal());
        dgm.setRows(rvolist);
        return dgm;
    }

    @Override
    public void saveRoles(RolesVo rolesVo) {
        rolesMapper.saveRoles(rolesVo);
    }

    @Override
    public void updateRoles(RolesVo rolesVo) {
        rolesMapper.updateRoles(rolesVo);
    }

    @Override
    public void delRoles(RolesVo rolesVo) {
        rolesMapper.delRoles(rolesVo);
    }

    @Override
    public List<RolesVo> loadAllRolesListService() {
        // TODO Auto-generated method stub
        RolesVo rolesVo=new RolesVo();
        //执行数据库查询
        List<Roles> rlist = rolesMapper.findRolesKey(rolesVo);

        List<RolesVo> rvoList=new ArrayList<>();

        for(Roles r:rlist){
            RolesVo vo = new RolesVo();
            BeanUtils.copyProperties(r,vo);
            rvoList.add(vo);
        }
       return rvoList;
    }
}
