package org.ps5jb.client.jdk.internal.access;

import java.io.FileDescriptor;

public interface JavaIOFileDescriptorAccess {
    int get(FileDescriptor fd);
}
