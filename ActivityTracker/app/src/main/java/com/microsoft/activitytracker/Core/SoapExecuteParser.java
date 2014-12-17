// Android Activity Tracker Sample app for Microsoft Dynamics CRM
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
// MIT License
//
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software
// and associated documentation files (the ""Software""), to deal in the Software without
// restriction, including without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
//    The above copyright notice and this permission notice shall be included in all copies
//    or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
// BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package com.microsoft.activitytracker.Core;

import java.lang.reflect.Type;
import java.util.Scanner;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class SoapExecuteParser implements Converter
{

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException
    {
        try
        {
            Scanner scanner = new Scanner(body.in()).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
        catch(Exception ex) {
            ex.getCause().printStackTrace();
            return null;
        }
    }

    @Override
    public TypedOutput toBody(Object object)
    {
        return null;
    }
}
