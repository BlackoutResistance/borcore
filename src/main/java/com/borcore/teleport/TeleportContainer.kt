package com.borcore.teleport

import java.util.*

class TeleportContainer private constructor() {

    companion object {

        private val queue: PriorityQueue<Request> = PriorityQueue()

        @JvmStatic
        fun addRequestToQueue(request: Request): Boolean = queue.offer(request)

        @JvmStatic
        fun removeRequestFromQueue(request: Request): Boolean = queue.remove(request)

        @JvmStatic
        fun findRequestBySender(sender: UUID): Request? {
            return queue.find { it.sender == sender }
        }

        @JvmStatic
        fun findRequestByReceiver(receiver: UUID): Request? {
            return queue.find { it.receiver == receiver }
        }

    }

}