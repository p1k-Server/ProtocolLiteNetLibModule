package com.pro100kryto.server.modules;

import com.pro100kryto.server.StartStopStatus;
import com.pro100kryto.server.logger.ILogger;
import com.pro100kryto.server.module.AModuleConnection;
import com.pro100kryto.server.module.Module;
import com.pro100kryto.server.modules.protocollitenetlib.IProtocol;
import com.pro100kryto.server.modules.protocollitenetlib.LiteNetLibProtocol;
import com.pro100kryto.server.modules.protocollitenetlib.connection.IProtocolModuleConnection;
import com.pro100kryto.server.modules.protocollitenetlib.connection.exceptions.AProtocolException;
import com.pro100kryto.server.service.IServiceControl;
import com.pro100kryto.server.utils.datagram.packets.IPacketInProcess;

public class ProtocolLiteNetLibModule extends Module {
    protected IProtocol protocol;

    public ProtocolLiteNetLibModule(IServiceControl service, String name) {
        super(service, name);
    }

    @Override
    protected void startAction() throws Throwable {
        if (moduleConnection==null){
            moduleConnection = new ProtocolModuleConnection(logger, name, type);
        }

        if (protocol==null) {
            protocol = new LiteNetLibProtocol();
        }
        protocol.start();
    }

    @Override
    protected void stopAction(boolean force) throws Throwable {
        protocol.stop(force);
        if (force) {
            protocol = null;
        }
    }

    @Override
    public void tick() throws Throwable {
        protocol.tick();
    }

    // ModuleConnection

    private final class ProtocolModuleConnection extends AModuleConnection implements IProtocolModuleConnection {

        public ProtocolModuleConnection(ILogger logger, String moduleName, String moduleType) {
            super(logger, moduleName, moduleType);
        }

        @Override
        public boolean isAliveModule() {
            return getStatus() == StartStopStatus.STARTED;
        }

        // -------------

        @Override
        public IPacketInProcess processPacketOnReceive(IPacketInProcess packet) throws AProtocolException {
            return protocol.onReceive(packet);
        }

        @Override
        public IPacketInProcess processPacketOnSend(IPacketInProcess packet) throws AProtocolException {
            return protocol.onSend(packet);
        }
    }
}
