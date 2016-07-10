//: com.greenhorn.build.gradle: InfoTaskTest.groovy
package com.greenhorn.build.gradle

import org.gradle.api.*
import org.gradle.testfixtures.ProjectBuilder

import org.junit.Test


class InfoTaskTest {


  @Test
  void testCreateTaskInProject() {

    final Task newTask = createInfoTask()
    assert newTask instanceof InfoTask

  }


  @Test
  void testPropertyValueIsSet() {

    final Task newTask = createInfoTask()

    newTask.configure {
      prefix = 'Test'
    }

    assert newTask.prefix == 'Test'

  }


  private Task createInfoTask() {

    final Project project = ProjectBuilder.builder().build()
    project.task( 'info', type: InfoTask )

  }


} //:~
