package com.pro100kryto.server.modules.protocollitenetlib.litenetlib;

import com.pro100kryto.server.utils.datagram.packets.IPacketInProcess;

public interface INetSocketListener {
    void OnMessageReceived(IPacketInProcess packetInProcess);
}
