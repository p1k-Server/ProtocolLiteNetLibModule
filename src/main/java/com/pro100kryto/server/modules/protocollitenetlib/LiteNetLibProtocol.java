package com.pro100kryto.server.modules.protocollitenetlib;

import com.pro100kryto.server.modules.protocollitenetlib.connection.exceptions.AProtocolException;
import com.pro100kryto.server.modules.protocollitenetlib.litenetlib.NetPacket;
import com.pro100kryto.server.utils.datagram.packets.EndPoint;
import com.pro100kryto.server.utils.datagram.packets.IPacketInProcess;

public class LiteNetLibProtocol extends ProtocolSimple {

    @Override
    public IPacketInProcess onReceive(IPacketInProcess packetInProcess) throws AProtocolException {
        packetInProcess.getDataCreator().cutLeft(NetPacket.GetHeaderSize(NetPacket.PacketProperty.UnconnectedMessage));
        return packetInProcess;
    }

    @Override
    public IPacketInProcess onSend(IPacketInProcess packetInProcess) throws AProtocolException {
        packetInProcess.getDataCreator().addLeft(true, NetPacket.PacketProperty.UnconnectedMessage);
        return packetInProcess;
    }

    @Override
    public void tick() throws Throwable {
    }

    @Override
    protected void startAction() throws Throwable {
    }

    @Override
    protected void stopAction() throws Throwable {
    }

    @Override
    public void connectEndPoint(EndPoint endPoint) {
    }

    @Override
    public boolean isEndPointAvailable(EndPoint endPoint) {
        return true;
    }

    @Override
    public void disconnectEndPoint(EndPoint endPoint) {
    }
}
