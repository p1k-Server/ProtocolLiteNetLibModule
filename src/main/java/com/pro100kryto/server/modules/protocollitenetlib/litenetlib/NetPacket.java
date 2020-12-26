package com.pro100kryto.server.modules.protocollitenetlib.litenetlib;

public class NetPacket {

    public static class PacketProperty{
        public static final byte Unreliable = 0;
        public static final byte Channeled = 1;
        public static final byte Ack = 2;
        public static final byte Ping = 3;
        public static final byte Pong = 4;
        public static final byte ConnectRequest = 5;
        public static final byte ConnectAccept = 6;
        public static final byte Disconnect = 7;
        public static final byte UnconnectedMessage = 8;
        public static final byte NatIntroductionRequest = 9;
        public static final byte NatIntroduction = 10;
        public static final byte NatPunchMessage = 11;
        public static final byte MtuCheck = 12;
        public static final byte  MtuOk = 13;
        public static final byte Broadcast = 14;
        public static final byte Merged = 15;
        public static final byte ShutdownOk = 16;
        public static final byte PeerNotFound = 17;
        public static final byte InvalidProtocol = 18;
    }

    public static int GetHeaderSize(byte property)
    {
        switch (property)
        {
            case PacketProperty.Channeled:
            case PacketProperty.Ack:
                return NetConstants.ChanneledHeaderSize;
            case PacketProperty.Ping:
                return NetConstants.HeaderSize + 2;
            case PacketProperty.ConnectRequest:
                return NetConnectRequestPacket.HeaderSize;
            //case ConnectAccept:
                //return NetConnectAcceptPacket.Size;
            case PacketProperty.Disconnect:
                return NetConstants.HeaderSize + 8;
            case PacketProperty.Pong:
                return NetConstants.HeaderSize + 10;
            default:
                return NetConstants.HeaderSize;
        }
    }

    public enum DeliveryMethod
    {
                /// <summary>
                /// Reliable. Packets won't be dropped, won't be duplicated, can arrive without order.
                /// </summary>
                ReliableUnordered,

                /// <summary>
                /// Unreliable. Packets can be dropped, won't be duplicated, will arrive in order.
                /// </summary>
                Sequenced,

                /// <summary>
                /// Reliable and ordered. Packets won't be dropped, won't be duplicated, will arrive in order.
                /// </summary>
                ReliableOrdered,

                /// <summary>
                /// Reliable only last packet. Packets can be dropped (except the last one), won't be duplicated, will arrive in order.
                /// </summary>
                ReliableSequenced,
        /// <summary>
        /// Unreliable. Packets can be dropped, can be duplicated, can arrive without order.
        /// </summary>
        Unreliable,
    }

    public final class NetConnectAcceptPacket{

    }
}
