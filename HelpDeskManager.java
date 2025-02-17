class HelpDeskManager {
    private HelpDesk[] helpDesks;

    public HelpDeskManager(int numberOfDesks, int maxQueueCapacity) {
        helpDesks = new HelpDesk[numberOfDesks];
        for (int i = 0; i < numberOfDesks; i++) {
            helpDesks[i] = new HelpDesk(maxQueueCapacity);
        }
    }

    public int addPersonToQueue(int personId) {
        int minQueueIndex = -1;
        int minQueueSize = Integer.MAX_VALUE;

        for (int i = 0; i < helpDesks.length; i++) {
            int currentQueueSize = helpDesks[i].getQueueSize();
            if (currentQueueSize < minQueueSize) {
                minQueueSize = currentQueueSize;
                minQueueIndex = i;
            }
        }

        if (minQueueSize < helpDesks[0].maxCapacity) {
            helpDesks[minQueueIndex].addPerson(personId);
            return minQueueIndex;
        }
        return -1;
    }

    public int removePersonFromDesk(int deskIndex) {
        if (deskIndex >= 0 && deskIndex < helpDesks.length) {
            return helpDesks[deskIndex].removePerson();
        }
        return -1;
    }
}
