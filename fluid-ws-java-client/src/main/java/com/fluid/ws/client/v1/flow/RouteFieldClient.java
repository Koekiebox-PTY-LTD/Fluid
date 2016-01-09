/*
 * Koekiebox CONFIDENTIAL
 *
 * [2012] - [2017] Koekiebox (Pty) Ltd
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of Koekiebox and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to Koekiebox
 * and its suppliers and may be covered by South African and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is strictly
 * forbidden unless prior written permission is obtained from Koekiebox.
 */

package com.fluid.ws.client.v1.flow;

import java.util.ArrayList;
import java.util.List;

import com.fluid.program.api.vo.Field;
import com.fluid.program.api.vo.MultiChoice;
import com.fluid.program.api.vo.ws.WS.Path.RouteField.Version1;
import com.fluid.ws.client.FluidClientException;
import com.fluid.ws.client.v1.ABaseFieldClient;

/**
 * Created by jasonbruwer on 15/01/04.
 */
public class RouteFieldClient extends ABaseFieldClient {

    /**
     *
     */
    public RouteFieldClient() {
        super();
    }

    /**
     *
     * @param serviceTicketParam
     */
    public RouteFieldClient(String serviceTicketParam) {
        super();

        this.setServiceTicket(serviceTicketParam);
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldTextPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.Text);
            formFieldParam.setTypeMetaData(FieldMetaData.Text.PLAIN);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldTrueFalse(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.TrueFalse);
            formFieldParam.setTypeMetaData(FieldMetaData.TrueFalse.TRUE_FALSE);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldParagraphTextPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.ParagraphText);
            formFieldParam.setTypeMetaData(FieldMetaData.ParagraphText.PLAIN);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldParagraphTextHTML(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.ParagraphText);
            formFieldParam.setTypeMetaData(FieldMetaData.ParagraphText.HTML);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @param multiChoiceValuesParam
     * @return
     */
    public Field createFieldMultiChoicePlain(
            Field formFieldParam, List<String> multiChoiceValuesParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(multiChoiceValuesParam == null)
        {
            multiChoiceValuesParam = new ArrayList<String>();
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.MultipleChoice);
            formFieldParam.setTypeMetaData(FieldMetaData.MultiChoice.PLAIN);
            formFieldParam.setFieldValue(new MultiChoice(multiChoiceValuesParam));
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @param multiChoiceValuesParam
     * @return
     */
    public Field createFieldMultiChoiceSelectMany(
            Field formFieldParam, List<String> multiChoiceValuesParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(multiChoiceValuesParam == null ||
                multiChoiceValuesParam.isEmpty())
        {
            throw new FluidClientException(
                    "No Multi-choice values provided.",
                    FluidClientException.ErrorCode.FIELD_VALIDATE);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.MultipleChoice);
            formFieldParam.setTypeMetaData(FieldMetaData.MultiChoice.SELECT_MANY);
            formFieldParam.setFieldValue(new MultiChoice(multiChoiceValuesParam));
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldDateTimeDate(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.DateTime);
            formFieldParam.setTypeMetaData(FieldMetaData.DateTime.DATE);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldDateTimeDateAndTime(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.DateTime);
            formFieldParam.setTypeMetaData(FieldMetaData.DateTime.DATE_AND_TIME);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field createFieldDecimalPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.Decimal);
            formFieldParam.setTypeMetaData(FieldMetaData.Decimal.PLAIN);
        }

        return new Field(this.putJson(
                formFieldParam, Version1.routeFieldCreate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldTextPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.Text);
            formFieldParam.setTypeMetaData(FieldMetaData.Text.PLAIN);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldTrueFalse(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.TrueFalse);
            formFieldParam.setTypeMetaData(FieldMetaData.TrueFalse.TRUE_FALSE);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldParagraphTextPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.ParagraphText);
            formFieldParam.setTypeMetaData(FieldMetaData.ParagraphText.PLAIN);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldParagraphTextHTML(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.ParagraphText);
            formFieldParam.setTypeMetaData(FieldMetaData.ParagraphText.HTML);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @param multiChoiceValuesParam
     * @return
     */
    public Field updateFieldMultiChoicePlain(
            Field formFieldParam,
            List<String> multiChoiceValuesParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(multiChoiceValuesParam == null ||
                multiChoiceValuesParam.isEmpty())
        {
            throw new FluidClientException(
                    "No Multi-choice values provided.",
                    FluidClientException.ErrorCode.FIELD_VALIDATE);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.MultipleChoice);
            formFieldParam.setTypeMetaData(FieldMetaData.MultiChoice.PLAIN);
            formFieldParam.setFieldValue(new MultiChoice(multiChoiceValuesParam));
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @param multiChoiceValuesParam
     * @return
     */
    public Field updateFieldMultiChoiceSelectMany(
            Field formFieldParam,
            List<String> multiChoiceValuesParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(multiChoiceValuesParam == null ||
                multiChoiceValuesParam.isEmpty())
        {
            throw new FluidClientException(
                    "No Multi-choice values provided.",
                    FluidClientException.ErrorCode.FIELD_VALIDATE);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.MultipleChoice);
            formFieldParam.setTypeMetaData(FieldMetaData.MultiChoice.SELECT_MANY);
            formFieldParam.setFieldValue(new MultiChoice(multiChoiceValuesParam));
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldDateTimeDate(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.DateTime);
            formFieldParam.setTypeMetaData(FieldMetaData.DateTime.DATE);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldDateTimeDateAndTime(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.DateTime);
            formFieldParam.setTypeMetaData(FieldMetaData.DateTime.DATE_AND_TIME);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param formFieldParam
     * @return
     */
    public Field updateFieldDecimalPlain(Field formFieldParam)
    {
        if(formFieldParam != null && this.serviceTicket != null)
        {
            formFieldParam.setServiceTicket(this.serviceTicket);
        }

        if(formFieldParam != null)
        {
            formFieldParam.setTypeAsEnum(Field.Type.Decimal);
            formFieldParam.setTypeMetaData(FieldMetaData.Decimal.PLAIN);
        }

        return new Field(this.postJson(
                formFieldParam, Version1.routeFieldUpdate()));
    }

    /**
     *
     * @param fieldIdParam
     * @return
     */
    public Field getFieldById(Long fieldIdParam)
    {
        Field flow = new Field(fieldIdParam);

        if(this.serviceTicket != null)
        {
            flow.setServiceTicket(this.serviceTicket);
        }

        return new Field(this.postJson(
                flow, Version1.getById()));
    }

    /**
     *
     * @param fieldParam
     * @return
     */
    public Field deleteField(Field fieldParam)
    {
        if(fieldParam != null && this.serviceTicket != null)
        {
            fieldParam.setServiceTicket(this.serviceTicket);
        }

        return new Field(this.postJson(fieldParam, Version1.routeFieldDelete()));
    }

    /**
     *
     * @param fieldParam
     * @return
     */
    public Field forceDeleteField(Field fieldParam)
    {
        if(fieldParam != null && this.serviceTicket != null)
        {
            fieldParam.setServiceTicket(this.serviceTicket);
        }

        return new Field(this.postJson(
                fieldParam, Version1.routeFieldDelete(true)));
    }

}
