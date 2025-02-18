class HelpDeskManager {
    private HelpDesk[] helpDesks;
    private int[] queueSizes;

    public HelpDeskManager(int numberOfDesks, int maxQueueCapacity) {
        helpDesks = new HelpDesk[numberOfDesks];
        queueSizes = new int[numberOfDesks];
        for (int i = 0; i < numberOfDesks; i++) {
            helpDesks[i] = new HelpDesk(maxQueueCapacity);
            queueSizes[i] = 0;
        }
    }

    public int addPersonToQueue(int personId) {
        int minQueueIndex = -1;
        int minQueueSize = Integer.MAX_VALUE;

        for (int i = 0; i < helpDesks.length; i++) {
            if (queueSizes[i] < minQueueSize) {
                minQueueSize = queueSizes[i];
                minQueueIndex = i;
            }
        }

        if (minQueueSize < helpDesks[0].getMaxCapacity()) {
            helpDesks[minQueueIndex].addPerson(personId);
            queueSizes[minQueueIndex]++;
            return minQueueIndex;
        }
        return -1;
    }

    public int removePersonFromDesk(int deskIndex) {
        if (deskIndex >= 0 && deskIndex < helpDesks.length) {
            int personId = helpDesks[deskIndex].removePerson();
            if (personId != -1) {
                queueSizes[deskIndex]--;
            }
            return personId;
        }
        return -1;
    }
}
