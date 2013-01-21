/*
 * Copyright 2012 selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.openqa.selendroid.server.handler;

import org.openqa.selendroid.android.internal.Base64Encoder;
import org.openqa.selendroid.server.RequestHandler;
import org.openqa.selendroid.server.Response;
import org.openqa.selendroid.util.SelendroidLogger;
import org.webbitserver.HttpRequest;

public class CaptureScreenshot extends RequestHandler {
  public CaptureScreenshot(HttpRequest request) {
    super(request);
  }

  @Override
  public Response handle() {
    SelendroidLogger.log("take screenshot command");
    byte[] rawPng = getAndroidDriver().takeScreenshot();
    String base64Png = new Base64Encoder().encode(rawPng);
    SelendroidLogger.log("take screenshot is done");
    return new Response(getSessionId(), base64Png);
  }
}
