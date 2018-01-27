package ru.nikitamugen.mqasyncexample;

public class Settings {
    public static final Settings INSTANCE =
            new Settings();

    private String brokerHost;

    private String brokerPort;

    public String getBrokerHost() {
        return brokerHost;
    }

    public void setBrokerHost(String brokerHost) {
        this.brokerHost = brokerHost;
    }

    public String getBrokerPort() {
        return brokerPort;
    }

    public void setBrokerPort(String brokerPort) {
        this.brokerPort = brokerPort;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "brokerHost='" + brokerHost + '\'' +
                ", brokerPort='" + brokerPort + '\'' +
                '}';
    }

    public String getBrokerUrl() {
        return String.format(
                "tcp://%s:%s",
                getBrokerHost(),
                getBrokerPort());
    }
}
