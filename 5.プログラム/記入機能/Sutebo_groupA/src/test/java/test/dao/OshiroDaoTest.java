//package test.dao;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import jp.co.example.dao.ItemDao;
//import jp.co.example.dao.MoneyDao;
//import jp.co.example.dao.UserDao;
//import jp.co.example.entity.User;
//
//class OshiroDaoTest {
//
//	@Autowired
//	UserDao userDao;
//	@Autowired
//	ItemDao itemDao;
//	@Autowired
//	MoneyDao moneyDao;
//
//	@Test
//	void test() {
//		List<User> users = userDao.usersIdFindUserId("axiz");
//		Integer inte = 1;
//
//		assertEqual(inte,users.get(0).getUsersId());
//	}
//
//}
