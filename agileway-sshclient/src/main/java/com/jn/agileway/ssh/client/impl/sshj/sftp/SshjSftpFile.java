package com.jn.agileway.ssh.client.impl.sshj.sftp;

import com.jn.agileway.ssh.client.sftp.SftpFile;
import com.jn.agileway.ssh.client.sftp.SftpSession;
import com.jn.agileway.ssh.client.sftp.filter.SftpFileFilter;
import com.jn.agileway.ssh.client.sftp.filter.SftpFilenameFilter;
import com.jn.langx.annotation.Nullable;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class SshjSftpFile extends SftpFile {

    public SshjSftpFile(SftpSession session, String path) {
        super(session, path, null, null);
    }

    public SshjSftpFile(SftpSession session, String path, @Nullable InputStream inputStream, @Nullable OutputStream outputStream) {
        super(session, path, null, inputStream, outputStream);
    }

    public SshjSftpFile(SftpSession session, String path, @Nullable String fileHandle, @Nullable InputStream inputStream, @Nullable OutputStream outputStream) {
        super(session, path, fileHandle, inputStream, outputStream);
    }

    @Override
    public void close() {
        this.isClosed = true;
    }

    @Override
    public int read(long fileOffset, byte[] buffer, int bufferOffset, int length) {
        return 0;
    }

    @Override
    public void write(long fileOffset, byte[] data, int offset, int length) {

    }

    @Override
    public List<String> list() {
        return null;
    }

    @Override
    public List<String> list(SftpFilenameFilter filter) {
        return null;
    }

    @Override
    public List<SftpFile> listFiles() {
        return null;
    }

    @Override
    public List<SftpFile> listFiles(SftpFilenameFilter filter) {
        return null;
    }

    @Override
    public List<SftpFile> listFiles(SftpFileFilter filter) {
        return null;
    }

    @Override
    public boolean exist() {
        return false;
    }
}