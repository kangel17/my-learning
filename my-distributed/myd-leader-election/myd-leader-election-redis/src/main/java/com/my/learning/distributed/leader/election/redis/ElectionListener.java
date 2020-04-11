package com.my.learning.distributed.leader.election.redis;

public interface ElectionListener {
    void onElected();
}
