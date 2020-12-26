package com.pro100kryto.server.modules.protocollitenetlib.litenetlib;

public interface INetEventListener {


    public enum UnconnectedMessageType
    {
        BasicMessage,
        Broadcast
    }

    public enum DisconnectReason
    {
        ConnectionFailed,
        Timeout,
        HostUnreachable,
        NetworkUnreachable,
        RemoteConnectionClose,
        DisconnectPeerCalled,
        ConnectionRejected,
        InvalidProtocol,
        UnknownHost,
        Reconnect
    }

    public interface DisconnectInfo{
        DisconnectReason getReason();
    }
}
