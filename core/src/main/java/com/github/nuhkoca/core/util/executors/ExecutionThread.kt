package com.github.nuhkoca.core.util.executors

import io.reactivex.Scheduler

interface ExecutionThread {
    val scheduler: Scheduler
}
