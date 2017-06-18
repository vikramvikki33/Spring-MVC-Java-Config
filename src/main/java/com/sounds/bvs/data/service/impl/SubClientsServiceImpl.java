/**
 *
 */
package com.sounds.bvs.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sounds.bvs.data.dao.SubClientDao;
import com.sounds.bvs.data.domain.SubClients;
import com.sounds.bvs.data.service.SubClientsService;

/**
 * @author Vikram
 *
 */
@Service
@Transactional
public class SubClientsServiceImpl implements SubClientsService {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	SubClientDao dao;
	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#findAll()
	 */
	@Override
	public List<SubClients> findAll() {
		return this.dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public SubClients findById(Integer id) {
		return this.dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public SubClients save(SubClients entity) {
		return this.dao.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public SubClients update(SubClients entity) {
		return this.dao.update(entity);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public SubClients saveOrUpdate(SubClients entity) {
		return this.dao.saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#flush()
	 */
	@Override
	public void flush() {
		this.dao.flush();
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#clear()
	 */
	@Override
	public void clear() {
		this.dao.clear();
	}

}
