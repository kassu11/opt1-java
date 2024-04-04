import jakarta.persistence.EntityManager;

public class LocalizationDao {
    public void persist(Localization data) {
        EntityManager em = MarjaDBJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();
    }
}
