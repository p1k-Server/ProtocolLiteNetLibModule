package com.pro100kryto.server.modules.protocollitenetlib;


import com.pro100kryto.server.StartStopStatus;

public abstract class ProtocolSimple implements IProtocol{
    private StartStopStatus status;

    @Override
    public final void start() throws Throwable {
        if (status != StartStopStatus.STOPPED) return;
        status = StartStopStatus.STARTING;
        startAction();
        status = StartStopStatus.STARTED;
    }

    @Override
    public final void stop(boolean force) throws Throwable {
        if (status != StartStopStatus.STARTED) return;
        status = StartStopStatus.STOPPING;
        stopAction();
        status = StartStopStatus.STOPPED;
    }

    @Override
    public final StartStopStatus getStatus() {
        return status;
    }

    protected abstract void startAction() throws Throwable;
    protected abstract void stopAction() throws Throwable;
}
