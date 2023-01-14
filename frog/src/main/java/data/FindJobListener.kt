package data

import kr.co.ky.findJob.FindJobDataClass

interface FindJobListener {
    fun getJobList(jobList: MutableList<FindJobDataClass>)
}