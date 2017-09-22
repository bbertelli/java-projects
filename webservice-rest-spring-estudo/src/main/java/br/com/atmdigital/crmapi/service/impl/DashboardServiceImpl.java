package br.com.atmdigital.crmapi.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.DashboardDao;
import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.DashboardService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class DashboardServiceImpl extends AbstractEntityServiceImpl<Usuario,DashboardDao,Long> implements DashboardService{
}
