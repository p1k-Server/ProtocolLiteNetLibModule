package com.pro100kryto.server.modules.protocollitenetlib.litenetlib;

import com.pro100kryto.server.utils.datagram.packets.DataReader;

public final class NetConnectRequestPacket {
    public static final int HeaderSize = 13;
    public final long ConnectionTime;
    public final byte ConnectionNumber;
    public final DataReader Data;

    public NetConnectRequestPacket(long connectionId, byte connectionNumber, DataReader data)
    {
        ConnectionTime = connectionId;
        ConnectionNumber = connectionNumber;
        Data = data;
    }
/*
    public static int GetProtocolId(NetPacket packet)
    {
        return DataReader.readInt(packet.RawData, 1);
    }

    public static NetConnectRequestPacket FromData(NetPacket packet)
    {
        if (packet.ConnectionNumber >= NetConstants.MaxConnectionNumber)
            return null;

        //Getting new id for peer
        long connectionId = DataReader.readLong(packet.RawData, 5);

        // Read data and create request
        DataReader reader;
        if (packet.Size > HeaderSize)
            reader = new DataReader(packet.RawData, HeaderSize);
        else
            reader = new DataReader(null);

        return new NetConnectRequestPacket(connectionId, packet.ConnectionNumber, reader);
    }

    public static NetPacket Make(DataCreator connectData, long connectId)
    {
        //Make initial packet
        NetPacket packet = new NetPacket(NetPacket.PacketProperty.ConnectRequest, connectData.Length);

        //Add data
        FastBitConverter.GetBytes(packet.RawData, 1, NetConstants.ProtocolId);
        FastBitConverter.GetBytes(packet.RawData, 5, connectId);
        Buffer.BlockCopy(connectData.Data, 0, packet.RawData, HeaderSize, connectData.Length);
        return packet;
    }*/
}
