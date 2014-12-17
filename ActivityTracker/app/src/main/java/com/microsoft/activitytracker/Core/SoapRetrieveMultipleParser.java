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

import com.microsoft.activitytracker.Classes.Entity;
import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class SoapRetrieveMultipleParser implements Converter {

    public static ArrayList<Entity> parseSoapXml(String XmlIn) throws XmlPullParserException, IOException
    {
        ArrayList<Entity> Entities = new ArrayList<Entity>();

        try {

            VTDGen vtdGen = new VTDGen();
            vtdGen.setDoc(XmlIn.getBytes());
            vtdGen.parse(true);

            VTDNav vtdNav = vtdGen.getNav();
            AutoPilot autoPilot = new AutoPilot(vtdNav);
            autoPilot.selectElementNS("http://schemas.microsoft.com/xrm/2011/Contracts", "Entity");

            while (autoPilot.iterate())
            {
                VTDNav vtdNavClone = vtdNav.cloneNav();
                //move to attributes
                vtdNavClone.toElement(VTDNav.FIRST_CHILD);

                Entity thisEntity = new Entity();

                do {

                    if (vtdNavClone.toNormalizedString(vtdNavClone.getCurrentIndex()).equals("a:Attributes"))
                    {
                        VTDNav attributesNav = vtdNavClone.cloneNav();
                        attributesNav.toElement(VTDNav.FIRST_CHILD);

                        do {
                            VTDNav KeyValNav = attributesNav.cloneNav();

                            if (KeyValNav.toElement(VTDNav.FIRST_CHILD)) {
                                String value, key = KeyValNav.toString(KeyValNav.getText());

                                KeyValNav.toElement(VTDNav.NS);
                                if (KeyValNav.toElement(VTDNav.LAST_CHILD)) {
                                    value = KeyValNav.toString(KeyValNav.getText());
                                }
                                else {
                                    value = KeyValNav.toString(KeyValNav.getText());
                                }

                                thisEntity.attributes.put(key, value);
                            }
                        } while (attributesNav.toElement(VTDNav.NEXT_SIBLING));
                    }

                    if (vtdNavClone.toNormalizedString(vtdNavClone.getCurrentIndex()).equals("a:Id"))
                    {
                        thisEntity.setId(vtdNavClone.toString(vtdNavClone.getText()));
                    }

                    if (vtdNavClone.toNormalizedString(vtdNavClone.getCurrentIndex()).equals("a:LogicalName"))
                    {
                        thisEntity.setLogicalName(vtdNavClone.toString(vtdNavClone.getText()));
                    }

                } while(vtdNavClone.toElement(VTDNav.NEXT_SIBLING));

                Entities.add(thisEntity);
            }
        }

        catch(Exception ex) {
            ex.getCause().printStackTrace();
        }

        return Entities;
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException
    {
        try
        {
            Scanner scanner = new Scanner(body.in()).useDelimiter("\\A");
            return parseSoapXml(scanner.hasNext() ? scanner.next() : "");
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
