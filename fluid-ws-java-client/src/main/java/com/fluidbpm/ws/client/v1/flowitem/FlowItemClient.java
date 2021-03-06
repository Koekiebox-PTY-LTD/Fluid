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

package com.fluidbpm.ws.client.v1.flowitem;

import com.fluidbpm.program.api.util.UtilGlobal;
import com.fluidbpm.program.api.vo.flow.JobView;
import com.fluidbpm.program.api.vo.form.Form;
import com.fluidbpm.program.api.vo.item.FluidItem;
import com.fluidbpm.program.api.vo.item.FluidItemListing;
import com.fluidbpm.program.api.vo.ws.WS;
import com.fluidbpm.ws.client.FluidClientException;
import com.fluidbpm.ws.client.v1.ABaseClientWS;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Java Web Service Client for Fluid / Flow Item related actions.
 *
 * @author jasonbruwer
 * @since v1.0
 *
 * @see JSONObject
 * @see com.fluidbpm.program.api.vo.ws.WS.Path.FlowItem
 * @see FluidItem
 */
public class FlowItemClient extends ABaseClientWS {

	/**
	 * Constructor that sets the Service Ticket from authentication.
	 *
	 * @param endpointBaseUrlParam URL to base endpoint.
	 * @param serviceTicketParam The Server issued Service Ticket.
	 */
	public FlowItemClient(
			String endpointBaseUrlParam,
			String serviceTicketParam) {
		super(endpointBaseUrlParam);
		this.setServiceTicket(serviceTicketParam);
	}

	/**
	 * Retrieves the Form Container by Primary key.
	 *
	 * @param formIdParam The Form primary key.
	 * @return Form by Primary key.
	 */
	public FluidItem getFluidItemByFormId(Long formIdParam) {
		Form form = new Form(formIdParam);
		if (this.serviceTicket != null) {
			form.setServiceTicket(this.serviceTicket);
		}

		return new FluidItem(this.postJson(
				form, WS.Path.FlowItem.Version1.getByForm()));
	}

	/**
	 * Creates a new Fluid Item that will be sent to the {@code flowJobItemParam}
	 * Flow.
	 *
	 * @param flowJobItemParam The Fluid Item to create and send to Workflow.
	 * @param flowNameParam The name of the Flow where the Item must be sent.
	 * @return The created Fluid item.
	 */
	public FluidItem createFlowItem(
		FluidItem flowJobItemParam,
		String flowNameParam
	) {
		if (flowJobItemParam != null && this.serviceTicket != null) {
			flowJobItemParam.setServiceTicket(this.serviceTicket);
		}

		//Flow Job Item Step etc...
		if (flowJobItemParam != null) {
			flowJobItemParam.setFlow(flowNameParam);
		}

		try {

			return new FluidItem(this.putJson(
					flowJobItemParam, WS.Path.FlowItem.Version1.flowItemCreate()));
		} catch (JSONException e) {
			throw new FluidClientException(e.getMessage(), e,
					FluidClientException.ErrorCode.JSON_PARSING);
		}
	}

	/**
	 * Retrieves items for the provided JobView.
	 *
	 * @param jobViewParam The {@link JobView} to retrieve items from.
	 * @param queryLimitParam The query limit.
	 * @param offsetParam The offset.
	 * @param sortFieldParam The sort field.
	 * @param sortOrderParam The sort order.
	 * @return The Fluid items for the {@code jobViewParam}.
	 */
	public FluidItemListing getFluidItemsForView(
		JobView jobViewParam,
		int queryLimitParam,
		int offsetParam,
		String sortFieldParam,
		String sortOrderParam
	) {
		if (this.serviceTicket != null && jobViewParam != null) {
			jobViewParam.setServiceTicket(this.serviceTicket);
		}

		try {
			return new FluidItemListing(this.postJson(
					jobViewParam,
					WS.Path.FlowItem.Version1.getByJobView(
							queryLimitParam,
							offsetParam,
							sortFieldParam,
							sortOrderParam
					)));
		} catch (JSONException jsonExcept) {
			//rethrow as a Fluid Client exception.
			throw new FluidClientException(jsonExcept.getMessage(),
					FluidClientException.ErrorCode.JSON_PARSING);
		}
	}

	/**
	 * Retrieves items for the provided JobView.
	 * No sorting or ordering for this method.
	 *
	 * @param jobViewParam The {@link JobView} to retrieve items from.
	 * @param queryLimitParam The query limit.
	 * @param offsetParam The offset.
	 * @return The Fluid items for the {@code jobViewParam}.
	 */
	public FluidItemListing getFluidItemsForView(
		JobView jobViewParam,
		int queryLimitParam,
		int offsetParam
	) {
		return this.getFluidItemsForView(
				jobViewParam,
				queryLimitParam,
				offsetParam,
				UtilGlobal.EMPTY,
				UtilGlobal.EMPTY);
	}

	/**
	 * Send a workflow item currently in an {@code Assignment} step to.
	 * Collaborator user send on is not allowed.
	 *
	 * @param flowJobItemParam The Fluid Item to {@code "Send On"} in the workflow process.
	 *
	 * @return The Fluid item that was sent on.
	 */
	public FluidItem sendFlowItemOn(FluidItem flowJobItemParam) {
		return this.sendFlowItemOn(flowJobItemParam, false);
	}

	/**
	 * Send a workflow item currently in an {@code Assignment} step to
	 *
	 * @param flowJobItemParam The Fluid Item to {@code "Send On"} in the workflow process.
	 * @param allowCollaboratorToSendOnParam All a collaborator user to also send on.
	 *
	 * @return The Fluid item that was sent on.
	 */
	public FluidItem sendFlowItemOn(
			FluidItem flowJobItemParam,
			boolean allowCollaboratorToSendOnParam
	) {
		if (flowJobItemParam != null) flowJobItemParam.setServiceTicket(this.serviceTicket);

		try {
			return new FluidItem(this.postJson(
					flowJobItemParam, WS.Path.FlowItem.Version1.sendFlowItemOn(
							allowCollaboratorToSendOnParam)));
		} catch (JSONException e) {
			throw new FluidClientException(e.getMessage(), e,
					FluidClientException.ErrorCode.JSON_PARSING);
		}
	}

	/**
	 * Send a form item to be part of a workflow.
	 *
	 * @param formToSendToFlowParam The Form to {@code "Send To Flow (introduction)"} in the workflow process.
	 * @param flowParam The Flow the {@code formToSendToFlowParam} must be sent to.
	 *
	 * @return The Fluid item that was initiated in a workflow process.
	 */
	public FluidItem sendFormToFlow(Form formToSendToFlowParam, String flowParam) {
		FluidItem itemToSend = new FluidItem();
		itemToSend.setForm(formToSendToFlowParam);
		itemToSend.setFlow(flowParam);
		itemToSend.setServiceTicket(this.serviceTicket);

		try {
			return new FluidItem(this.postJson(
					itemToSend, WS.Path.FlowItem.Version1.sendFlowItemToFlow()));
		} catch (JSONException e) {
			throw new FluidClientException(e.getMessage(), e,
					FluidClientException.ErrorCode.JSON_PARSING);
		}
	}

	/**
	 * Remove a {@code FluidItem} from the workflow.
	 *
	 * @param fluidItem The Form to {@code "Send To Flow (introduction)"} in the workflow process.
	 *
	 * @return The Fluid item that was removed from the workflow process.
	 *
	 * @see FluidItem
	 */
	public FluidItem removeFromFlow(FluidItem fluidItem) {
		if (fluidItem != null) {
			fluidItem.setServiceTicket(this.serviceTicket);
		}

		try {
			return new FluidItem(this.postJson(
					fluidItem, WS.Path.FlowItem.Version1.removeFluidItemFromFlow()));
		} catch (JSONException e) {
			throw new FluidClientException(e.getMessage(), e,
					FluidClientException.ErrorCode.JSON_PARSING);
		}
	}
}
