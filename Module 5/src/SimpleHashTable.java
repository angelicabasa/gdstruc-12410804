public class SimpleHashTable {
    private StoredPlayer[] hashtable;

    public SimpleHashTable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            // do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        // found the right key?
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
            // do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && hashtable[hashedKey] != null &&
                    !hashtable[hashedKey].key.equals(key)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }

            if (hashtable[hashedKey] != null
            && hashtable[hashedKey].key.equals(key)) {
                return hashedKey;
            }
    return -1;
    }

    public Player remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        Player removedPlayer =  hashtable[hashedKey].value;
        hashtable[hashedKey] = null;

        StoredPlayer[] previousHashTable = hashtable;
        hashtable = new StoredPlayer[previousHashTable.length];

        for (StoredPlayer storedPlayer : previousHashTable) {
            if (storedPlayer != null) {
                put(storedPlayer.key, storedPlayer.value);
            }
        }
        return removedPlayer;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else
            {
                System.out.println("Element " + i + " null");
            }
        }
    }
}
