/**
 *
 */
package com.sounds.bvs.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sounds.bvs.data.dao.ClientsDao;
import com.sounds.bvs.data.domain.Clients;
import com.sounds.bvs.data.service.ClientsService;

/**
 * @author Vikram
 *
 */
@Service
@Transactional
public class ClientsServiceImpl implements ClientsService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ClientsDao dao;

	@Override
	public List<Clients> findAll() {
		return this.dao.findAll();
	}

	@Override
	public Clients findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public Clients save(Clients entity) {
		entity.getClientDetails().setClients(entity);
		return this.dao.save(entity);
	}

	@Override
	public Clients update(Clients entity) {
		entity.getClientDetails().setClients(entity);
		return this.dao.update(entity);
	}

	@Override
	public Clients saveOrUpdate(Clients entity) {
		return this.dao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		this.dao.flush();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.dao.clear();
	}

}
