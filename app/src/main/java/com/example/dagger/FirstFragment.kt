package com.example.dagger

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.dagger.application_graph.ApplicationGraph
import com.example.dagger.application_graph.DaggerApplicationGraph
import com.example.dagger.dagger_test.TestClass
import com.example.dagger.dagger_test.TestUserClass
import com.example.dagger.user.UserLocalDataSource
import com.example.dagger.user.UserRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()
    private val userRepository: UserRepository = applicationGraph.repository()
    private val testClass: TestClass = applicationGraph.getTestClass()
    private val testUserClass: TestUserClass = applicationGraph.getTestUserClass()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val data = userRepository.getUserRemoteDataSource().getData()
//        val test1 = userRepository.getUserLocalDataSource().getTest1()
//        val test2 = userRepository.getUserLocalDataSource().getTest2()
//        val testClassName = testClass.getName()
//        val testClassUserName = testClass.getTestUserClassName()
//        val testClassUserToString = testUserClass.toString()
//        val testUserClassGetCassName = testUserClass.getClassName()
//        Log.d("Logs", "" +
//                test1 + " " +
//                test2 + " " +
//                data + " " +
//                testClassName  + " " +
//                testClassUserName  + " " +
//                testClassUserToString + " " +
//                testUserClassGetCassName
//        )
        userRepository.testRx()?.subscribe(userRepository.getObserver())

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}