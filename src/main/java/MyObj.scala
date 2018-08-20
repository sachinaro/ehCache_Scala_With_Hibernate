import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import javax.persistence.Query

object MyObj {

  def main(args: Array[String]): Unit = {
    val conf: Configuration =
        new Configuration().configure().addAnnotatedClass(classOf[Student])
    val sf: SessionFactory = conf.buildSessionFactory()
    val session1: Session = sf.openSession()
    session1.beginTransaction()
    var s = new Student()
   
    s = session1.get(classOf[Student],10)
    println(s)
    
    session1.getTransaction.commit()  
    session1.close()
    
    val session2: Session = sf.openSession()
    session2.beginTransaction()
    
    s = session2.get(classOf[Student],10)
    println(s)
    
    session2.getTransaction.commit()
    session2.close()
  }
}
