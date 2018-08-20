import javax.persistence.Cacheable
import javax.persistence.Entity
import javax.persistence.Id
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import scala.beans.{BeanProperty, BooleanBeanProperty}

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
class Student {

  @Id
  @BeanProperty
  var roll: Int = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var marks: Int = _

  override def toString(): String =
    "Student [roll=" + roll + ", name=" + name + ", marks=" +
      marks +
      "]"

}