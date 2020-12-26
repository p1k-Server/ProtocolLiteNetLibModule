package com.pro100kryto.server.modules.protocollitenetlib;


import com.pro100kryto.server.IStartStopAlive;
import com.pro100kryto.server.modules.protocollitenetlib.connection.exceptions.AProtocolException;
import com.pro100kryto.server.utils.datagram.packets.EndPoint;
import com.pro100kryto.server.utils.datagram.packets.IPacketInProcess;

public interface IProtocol extends IStartStopAlive {
    IPacketInProcess onReceive(IPacketInProcess protocolData) throws AProtocolException;
    IPacketInProcess onSend(IPacketInProcess protocolData) throws AProtocolException;
    void tick() throws Throwable;
    void connectEndPoint(EndPoint endPoint);
    boolean isEndPointAvailable(EndPoint endPoint);
    void disconnectEndPoint(EndPoint endPoint);
}
