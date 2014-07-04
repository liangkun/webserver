/*
 * Copyright (c) 2014 Data Intelli Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dataintelli

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// WebServer defines the service behavior independently from the server actor.
trait WebServer extends HttpService {
  def htdocs: String = "/htdocs"

  val route = {
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          getFromFile(s"$htdocs/index.html")
        }
      }
    }
  }
}

class WebServerActor(override val htdocs: String) extends Actor with WebServer {
  // @see HttpService.actorRefFactory
  override def actorRefFactory = context

  // @see HttpService.receive
  override def receive = runRoute(route)
}