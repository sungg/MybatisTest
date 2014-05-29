package tom.dao;

import tom.po.UserEntity;

/**
 * @author cuipeijun
 *
 */
public interface IUser {
	public UserEntity findById(int id);
}

