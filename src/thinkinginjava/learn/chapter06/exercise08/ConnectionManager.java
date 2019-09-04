package thinkinginjava.learn.chapter06.exercise08;

public class ConnectionManager {

    private ConnectionManager() {
    }

    private static int count = 0;
    private static Connection[] connections = new Connection[10];


    public static Connection createConnection() {
        Connection connection = new Connection();
        connections[count++] = connection;
        return connection;
    }

    public static int getCount() {
        return count;
    }

    public static int getLength() {
        return connections.length;
    }

    public static Connection getLastConnection() {
        if (count == 0) {
            return null;
        } else {
            return connections[count - 1];
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionManager.getLastConnection();
        System.out.println(connection==null);
        connection = ConnectionManager.createConnection();
        System.out.println(connection);

    }
}


class Connection {
    @Override
    public String toString() {
        return "Connection{}";
    }
}