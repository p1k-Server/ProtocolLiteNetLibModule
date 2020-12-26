package com.pro100kryto.server.modules.protocollitenetlib.litenetlib;

public class NetConstants {
    //can be tuned
    public static final int DefaultWindowSize = 64;
    public static final int SocketBufferSize = 1024 * 1024; //1mb
    public static final int SocketTTL = 255;

    public static final int HeaderSize = 1;
    public static final int ChanneledHeaderSize = 4;
    public static final int FragmentHeaderSize = 6;
    public static final int FragmentedHeaderTotalSize = ChanneledHeaderSize + FragmentHeaderSize;
    public static final int MaxSequence = 32768;
    public static final int HalfMaxSequence = MaxSequence / 2;

    //protocol
    public static final int ProtocolId = 10;
    public static final int MaxUdpHeaderSize = 68;

    public static final int[] PossibleMtu =
            {
                    576  - MaxUdpHeaderSize, //minimal
                    1232 - MaxUdpHeaderSize,
                    1460 - MaxUdpHeaderSize, //google cloud
                    1472 - MaxUdpHeaderSize, //VPN
                    1492 - MaxUdpHeaderSize, //Ethernet with LLC and SNAP, PPPoE (RFC 1042)
                    1500 - MaxUdpHeaderSize  //Ethernet II (RFC 1191)
            };

    public static final int MaxPacketSize = PossibleMtu[PossibleMtu.length - 1];

    //peer specific
    public static final byte MaxConnectionNumber = 4;

    public static final int PacketPoolSize = 1000;
}
