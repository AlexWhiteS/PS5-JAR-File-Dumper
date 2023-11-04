package org.ps5jb.client;

import org.ps5jb.loader.Status;
import com.sony.gemstack.org.dvb.io.ixc.IxcProxy;
import com.sony.gemstack.core.CoreIxcClassLoader;
import com.sony.gemstack.core.CoreAppContext;

public class PrivilegeEscalationProxy extends IxcProxy {
    private Object remoteObject = null;

    public PrivilegeEscalationProxy(Object obj) {
        super(CoreAppContext.getContext().getIxcClassLoader(),
                CoreAppContext.getContext().getIxcClassLoader());
        remoteObject = obj;
    }

    public Object invokeMethod(Object[] args, String name, String signature) {
        try {
            return super.invokeMethod(args, name, signature);
        } catch (Exception ex) {
            Status.println(String.valueOf(ex));
            return null;
        }
    }

    public void forgetRemote() {
        remoteObject = null;
    }

    public Object getRemote() {
        return remoteObject;
    }

    public Object replaceObject(Object obj, CoreIxcClassLoader loader) {
        remoteObject = obj;
        return remoteObject;
    }
}

