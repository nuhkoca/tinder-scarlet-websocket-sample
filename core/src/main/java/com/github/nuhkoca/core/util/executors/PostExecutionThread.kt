package com.github.nuhkoca.core.util.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}
