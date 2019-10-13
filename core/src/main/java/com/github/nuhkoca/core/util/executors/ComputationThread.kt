package com.github.nuhkoca.core.util.executors

import io.reactivex.Scheduler

interface ComputationThread {
    val scheduler: Scheduler
}
