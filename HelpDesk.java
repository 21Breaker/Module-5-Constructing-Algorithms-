import java.util.LinkedList;
import java.util.Queue;

class HelpDesk {
    private Queue<Integer> queue;
    private int maxCapacity;

    public HelpDesk(int maxCapacity) {
        this.queue = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    public boolean addPerson(int personId) {
        if (queue.size() < maxCapacity) {
            queue.add(personId);
            return true;
        }
        return false;
    }

    public int removePerson() {
        return queue.poll();
    }

    public int getQueueSize() {
        return queue.size();
    }
}
