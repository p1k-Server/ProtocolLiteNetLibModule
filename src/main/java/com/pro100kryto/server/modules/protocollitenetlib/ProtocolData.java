package com.pro100kryto.server.modules.protocollitenetlib;

import java.net.InetAddress;

public class ProtocolData {
    protected InetAddress address;
    protected int port;
    protected byte[] data;
    protected int offset;

    public ProtocolData(InetAddress address, int port, byte[] data){
        this(address, port, data, 0);
    }

    public ProtocolData(InetAddress address, int port, byte[] data, int offset) {
        this.address = address;
        this.port = port;
        this.data = data;
        this.offset = offset;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
