package com.pro100kryto.server.modules.protocollitenetlib;

import com.pro100kryto.server.StartStopStatus;

public abstract class ProtocolThread implements IProtocol, Runnable{
    protected Thread thread;

    @Override
    public final void start() throws Throwable {
        if (getStatus() != StartStopStatus.STOPPED) throw new IllegalStateException("Is not stopped");
        startAction();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public final void stop(boolean force) throws Throwable{
        if (getStatus() != StartStopStatus.STARTED) throw new IllegalStateException("Is not started");
        stopAction();
        if (thread!=null) {
            thread.interrupt();
            thread = null;
        }
    }

    @Override
    public StartStopStatus getStatus() {
        if (thread!=null && thread.isAlive()) return StartStopStatus.STARTED;
        return StartStopStatus.STOPPED;
    }

    protected abstract void startAction() throws Throwable;
    protected abstract void stopAction() throws Throwable;
}
