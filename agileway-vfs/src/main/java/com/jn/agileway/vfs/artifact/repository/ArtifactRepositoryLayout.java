package com.jn.agileway.vfs.artifact.repository;

import com.jn.agileway.vfs.artifact.Artifact;

public interface ArtifactRepositoryLayout {
    String getPath(Artifact artifact);
}
