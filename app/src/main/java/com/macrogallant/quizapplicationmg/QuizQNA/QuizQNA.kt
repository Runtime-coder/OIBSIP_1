package com.macrogallant.quizapplicationmg.QuizQNA

import com.macrogallant.quizapplicationmg.QuizQuestion

object QuizQNA {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"
    fun getQuestions(): ArrayList<QuizQuestion>{
        val questionList = ArrayList<QuizQuestion>()

        val que1 = QuizQuestion(
            1,
            "To keep the UI running smoothly, use ___ for long-running tasks, such as all database operations.",
            "coroutines",
            "returns",
            "ViewModels",
            "managed threads",
            1
        )
        questionList.add(que1)

        val que2 = QuizQuestion(
            2,
            "You can create an emulator to simulate the configuration of a particular type of Android device using a tool like ___.",
            "Virtual Editor",
            "AVD Manager",
            "Android SDK Manager",
            "Theme Editor",
            2
        )
        questionList.add(que2)

        val que3 = QuizQuestion(
            3,
            "What parameter specifies the Android API level that Gradle should use to compile your app?",
            "testSdkVersion",
            "targetSdkVersion",
            "minSdkVersion",
            "compileSdkVersion",
            4
        )
        questionList.add(que3)
        val que4 = QuizQuestion(
            4,
            "___ is a way to restrict direct access to some of an object’s fields.",
            "LiveData",
            "Score",
            "Encapsulation",
            "GameViewModel",
            3
        )
        questionList.add(que4)
        val que5 = QuizQuestion(
            5,
            "On which thread services work in android?",
            "Worker Thread",
            "Own Thread",
            "Main Thread",
            "None of the above.",
            3
        )
        questionList.add(que5)
        val que6 = QuizQuestion(
            6,
            "Data can be read from local source XML in android through",
            "XML resource parser",
            "XML pull parsing",
            "DOM parsing",
            " None of the above",
            1
        )
        questionList.add(que6)
        val que7 = QuizQuestion(
            7,
            "What is a thread in android?",
            "Background activity",
            "Same as services",
            "Broadcast Receiver",
            "Independent dis-patchable unit is called a thread",
            4
        )
        questionList.add(que7)
        val que8 = QuizQuestion(
            8,
            "On which thread services work in android?",
            "None of the above.",
            "Main Thread",
            "Own Thread",
            "Worker Thread",
            2
        )
        questionList.add(que8)
        val que9 = QuizQuestion(
            9,
            "In which directory XML layout files are stored?",
            "/assets",
            "/src",
            "/res/values",
            "/res/layout",
            4
        )
        questionList.add(que9)
        val que10 = QuizQuestion(
            10,
            "Adb Stands for ..............",
            "Android Debug Bridge.",
            "Android Drive Bridge.",
            "Android Delete Bridge",
            "Android Destroy Bridge.",
            1
        )
        questionList.add(que10)
        return questionList
    }
}