package Model;

/**
 * An interface that represents a class that updates objects dependent
 * on if the objects in the class depend on them.
 *
 * @param <Subject> serves as the type the object that is
 * implementing this interface is observing.
 * @author Andreas Leonard-Calcano
 *
 */
public interface Observer<Subject> {
    /*
        The class that is being Observed calls this method
        to notify their observers, to change state with
     */
    void update(Subject subject);
}
