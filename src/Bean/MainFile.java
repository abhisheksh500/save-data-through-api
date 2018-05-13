package Bean;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.client.RestTemplate;



public class MainFile {

	public static void main(String[] args)  {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		Session session = Factory.openSession();
		MainFile mn = new MainFile();
		RestTemplate resttemplate =new RestTemplate();
			//

		try {
			 String quote =resttemplate.getForObject("http://abhishek-pc:8080/BankWeb/rest/Banking/h1?name=sham&address=mohali&amount=1089879",String.class);
			 int a=0;
//			 ObjectMapper mapper = new ObjectMapper();
//		        POJO users = mapper.readValue(forObject,POJO.class);
//			mn.save(session,quote);
			System.out.println(quote);
			
			System.out.println("successfully saved");
		} 
		catch (Exception e) {
			throw e;
		}
		finally
		{
			session.close();
		}
	}

	// save method
	public void save(Session session, String name)
	{
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			POJO pj = new POJO();
			POJOBank pjb = new POJOBank();
			 
			 pj.setName(name);
			 pj.setAddress("mohali");
			 pj.setAmount(760);
			
			
			session.save(pj);
			
			int id;
			id=pj.getId();
			pjb.setCus_id(id);
			session.save(pjb);
			tx.commit();
		}
		catch (HibernateException hx) {
			if (tx != null)
				tx.rollback();
			throw hx;
		}
	}
}
