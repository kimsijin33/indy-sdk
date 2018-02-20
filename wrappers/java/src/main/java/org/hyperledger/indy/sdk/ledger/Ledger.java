package org.hyperledger.indy.sdk.ledger;

import java.util.concurrent.CompletableFuture;

import org.hyperledger.indy.sdk.IndyException;
import org.hyperledger.indy.sdk.IndyJava;
import org.hyperledger.indy.sdk.LibIndy;
import org.hyperledger.indy.sdk.ParamGuard;
import org.hyperledger.indy.sdk.StringUtils;
import org.hyperledger.indy.sdk.pool.Pool;
import org.hyperledger.indy.sdk.wallet.Wallet;

import com.sun.jna.Callback;

/**
 * ledger.rs API
 */

/**
 * Functionality related to the ledger.
 */
public class Ledger extends IndyJava.API {

	private Ledger() {

	}

	/* 
	 * STATIC CALLBACKS
	 */

	/**
	 * Callback used when signAndSubmitRequest completes.
	 */
	private static Callback signAndSubmitRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_result_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_result_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when submitRequest completes.
	 */
	private static Callback submitRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_result_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_result_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when signRequest completes.
	 */
	private static Callback signRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String signed_request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = signed_request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetDdoRequest completes.
	 */
	private static Callback buildGetDdoRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildNymRequest completes.
	 */
	private static Callback buildNymRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildAttribRequest completes.
	 */
	private static Callback buildAttribRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetAttribRequest completes.
	 */
	private static Callback buildGetAttribRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetNymRequest completes.
	 */
	private static Callback buildGetNymRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildSchemaRequest completes.
	 */
	private static Callback buildSchemaRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetSchemaRequest completes.
	 */
	private static Callback buildGetSchemaRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildClaimDefTxn completes.
	 */
	private static Callback buildClaimDefTxnCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetClaimDefTxn completes.
	 */
	private static Callback buildGetClaimDefTxnCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildNodeRequest completes.
	 */
	private static Callback buildNodeRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildGetTxnRequest completes.
	 */
	public static Callback buildGetTxnRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildPoolConfigRequest completes.
	 */
	public static Callback buildPoolConfigRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildPoolUpgradeRequest completes.
	 */
	public static Callback buildPoolUpgradeRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildRrevocRegDefRequest completes.
	 */
	public static Callback buildRevocRegDefRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/**
	 * Callback used when buildRrevocRegDeltaRequest completes.
	 */
	public static Callback buildRevocRegDeltaRequestCb = new Callback() {

		@SuppressWarnings({"unused", "unchecked"})
		public void callback(int xcommand_handle, int err, String request_json) {

			CompletableFuture<String> future = (CompletableFuture<String>) removeFuture(xcommand_handle);
			if (! checkCallback(future, err)) return;

			String result = request_json;
			future.complete(result);
		}
	};

	/*
	 * STATIC METHODS
	 */

	/**
	 * Signs and submits request message to validator pool.
	 *
	 * @param pool         A Pool.
	 * @param wallet       A Wallet.
	 * @param submitterDid Id of Identity stored in secured Wallet.
	 * @param requestJson  Request data json.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> signAndSubmitRequest(
			Pool pool,
			Wallet wallet,
			String submitterDid,
			String requestJson) throws IndyException {

		ParamGuard.notNull(pool, "pool");
		ParamGuard.notNull(wallet, "wallet");
		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(requestJson, "requestJson");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int poolHandle = pool.getPoolHandle();
		int walletHandle = wallet.getWalletHandle();

		int result = LibIndy.api.indy_sign_and_submit_request(
				commandHandle,
				poolHandle,
				walletHandle,
				submitterDid,
				requestJson,
				signAndSubmitRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Publishes request message to validator pool (no signing, unlike sign_and_submit_request).
	 *
	 * @param pool        The Pool to publish to.
	 * @param requestJson Request data json.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> submitRequest(
			Pool pool,
			String requestJson) throws IndyException {

		ParamGuard.notNull(pool, "pool");
		ParamGuard.notNullOrWhiteSpace(requestJson, "requestJson");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int poolHandle = pool.getPoolHandle();

		int result = LibIndy.api.indy_submit_request(
				commandHandle,
				poolHandle,
				requestJson,
				submitRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Signs request message.
	 *
	 * @param wallet       A Wallet.
	 * @param submitterDid Id of Identity stored in secured Wallet.
	 * @param requestJson  Request data json.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> signRequest(
			Wallet wallet,
			String submitterDid,
			String requestJson) throws IndyException {

		ParamGuard.notNull(wallet, "wallet");
		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(requestJson, "requestJson");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int walletHandle = wallet.getWalletHandle();

		int result = LibIndy.api.indy_sign_request(
				commandHandle,
				walletHandle,
				submitterDid,
				requestJson,
				signRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a request to get a DDO.
	 *
	 * @param submitterDid Id of Identity stored in secured Wallet.
	 * @param targetDid    Id of Identity stored in secured Wallet.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetDdoRequest(
			String submitterDid,
			String targetDid) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_ddo_request(
				commandHandle,
				submitterDid,
				targetDid,
				buildGetDdoRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a NYM request. Request to create a new NYM record for a specific user.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param targetDid    Target DID as base58-encoded string for 16 or 32 bit DID value.
	 * @param verkey       Target identity verification key as base58-encoded string.
	 * @param alias        NYM's alias.
	 * @param role         Role of a user NYM record:
	 *                        null (common USER)
	 *                        TRUSTEE
	 *                        STEWARD
	 *                        TRUST_ANCHOR
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildNymRequest(
			String submitterDid,
			String targetDid,
			String verkey,
			String alias,
			String role) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_nym_request(
				commandHandle,
				submitterDid,
				targetDid,
				verkey,
				alias,
				role,
				buildNymRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds an ATTRIB request. Request to add attribute to a NYM record.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param targetDid    Target DID as base58-encoded string for 16 or 32 bit DID value.
	 * @param hash         (Optional) Hash of attribute data.
	 * @param raw          (Optional) Json, where key is attribute name and value is attribute value.
	 * @param enc          (Optional) Encrypted value attribute data.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildAttribRequest(
			String submitterDid,
			String targetDid,
			String hash,
			String raw,
			String enc) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_attrib_request(
				commandHandle,
				submitterDid,
				targetDid,
				hash,
				raw,
				enc,
				buildAttribRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a GET_ATTRIB request. Request to get information about an Attribute for the specified DID.
	 *
	 * @param submitterDid DID of the read request sender.
	 * @param targetDid    Target DID as base58-encoded string for 16 or 32 bit DID value.
	 * @param raw          (Optional) Requested attribute name.
	 * @param hash         (Optional) Requested attribute hash.
	 * @param enc          (Optional) Requested attribute encrypted value.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetAttribRequest(
			String submitterDid,
			String targetDid,
			String raw,
			String hash,
			String enc) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_attrib_request(
				commandHandle,
				submitterDid,
				targetDid,
				raw,
				hash,
				enc,
				buildGetAttribRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a GET_NYM request. Request to get information about a DID (NYM).
	 *
	 * @param submitterDid DID of the read request sender.
	 * @param targetDid    Target DID as base58-encoded string for 16 or 32 bit DID value.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetNymRequest(
			String submitterDid,
			String targetDid) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_nym_request(
				commandHandle,
				submitterDid,
				targetDid,
				buildGetNymRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a SCHEMA request. Request to add Claim's schema.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param data         {
	 *                        attr_names: array of attribute name strings
	 *                        name: Schema's name string
	 *                        version: Schema's version string
	 *                     }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildSchemaRequest(
			String submitterDid,
			String data) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(data, "data");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_schema_request(
				commandHandle,
				submitterDid,
				data,
				buildSchemaRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a GET_SCHEMA request. Request to get Claim's Schema.
	 *
	 * @param submitterDid DID of read request sender.
	 * @param dest         Schema Issuer's DID as base58-encoded string for 16 or 32 bit DID value.
	 *                     It differs from submitter_did field.
	 * @param data         {
	 *                        name (string): Schema's name string
	 *                        version (string): Schema's version string
	 *                     }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetSchemaRequest(
			String submitterDid,
			String dest,
			String data) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(dest, "dest");
		ParamGuard.notNullOrWhiteSpace(data, "data");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_schema_request(
				commandHandle,
				submitterDid,
				dest,
				data,
				buildGetSchemaRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds an CLAIM_DEF request. Request to add a claim definition (in particular, public key),
	 * that Issuer creates for a particular Claim Schema.
	 *
	 * @param submitterDid  DID of the submitter stored in secured Wallet.
	 * @param xref          Sequence number of a Schema transaction the claim definition is created for.
	 * @param signatureType Type of the claim definition. CL is the only supported type now.
	 * @param data          Dictionary with Claim Definition's data: {
	 *                         primary: primary claim public key
	 *                         revocation: revocation claim public key
	 *                     }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildClaimDefTxn(
			String submitterDid,
			int xref,
			String signatureType,
			String data) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(signatureType, "signatureType");
		ParamGuard.notNullOrWhiteSpace(data, "data");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_claim_def_txn(
				commandHandle,
				submitterDid,
				xref,
				signatureType,
				data,
				buildClaimDefTxnCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a GET_CLAIM_DEF request. Request to get a claim definition (in particular, public key),
	 * that Issuer creates for a particular Claim Schema.
	 *
	 * @param submitterDid  DID of read request sender.
	 * @param xref          Sequence number of a Schema transaction the claim definition is created for.
	 * @param signatureType Type of the claim definition. CL is the only supported type now.
	 * @param origin        Claim Definition Issuer's DID as base58-encoded string for 16 or 32 bit DID value.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetClaimDefTxn(
			String submitterDid,
			int xref,
			String signatureType,
			String origin) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(signatureType, "signatureType");
		ParamGuard.notNullOrWhiteSpace(origin, "origin");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_claim_def_txn(
				commandHandle,
				submitterDid,
				xref,
				signatureType,
				origin,
				buildGetClaimDefTxnCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a NODE request. Request to add a new node to the pool, or updates existing in the pool.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param targetDid    Target Node's DID.  It differs from submitter_did field.
	 * @param data         Data associated with the Node: {
	 *                        alias: string - Node's alias
	 *                        blskey: string - (Optional) BLS multi-signature key as base58-encoded string.
	 *                        client_ip: string - (Optional) Node's client listener IP address.
	 *                        client_port: string - (Optional) Node's client listener port.
	 *                        node_ip: string - (Optional) The IP address other Nodes use to communicate with this Node.
	 *                        node_port: string - (Optional) The port other Nodes use to communicate with this Node.
	 *                        services: array<string> - (Optional) The service of the Node. VALIDATOR is the only supported one now.
	 *                    }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildNodeRequest(
			String submitterDid,
			String targetDid,
			String data) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");
		ParamGuard.notNullOrWhiteSpace(targetDid, "targetDid");
		ParamGuard.notNullOrWhiteSpace(data, "data");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_node_request(
				commandHandle,
				submitterDid,
				targetDid,
				data,
				buildNodeRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a GET_TXN request. Request to get any transaction by its seq_no.
	 *
	 * @param submitterDid DID of read request sender.
	 * @param data seq_no of transaction in ledger.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildGetTxnRequest(
			String submitterDid,
			int data) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_get_txn_request(
				commandHandle,
				submitterDid,
				data,
				buildGetTxnRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a POOL_CONFIG request. Request to change Pool's configuration.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param writes Whether any write requests can be processed by the pool
	 *              (if false, then pool goes to read-only state). True by default.
	 * @param force Whether we should apply transaction (for example, move pool to read-only state)
	 *                 without waiting for consensus of this transaction.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildPoolConfigRequest(
			String submitterDid,
			boolean writes,
			boolean force) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_pool_config_request(
				commandHandle,
				submitterDid,
				writes,
				force,
				buildPoolConfigRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a POOL_UPGRADE request. Request to upgrade the Pool (sent by Trustee).
	 * It upgrades the specified Nodes (either all nodes in the Pool, or some specific ones).
	 *
	 * @param submitterDid  DID of the submitter stored in secured Wallet.
	 * @param name Human-readable name for the upgrade.
	 * @param version The version of indy-node package we perform upgrade to.
	 *                Must be greater than existing one (or equal if reinstall flag is True).
	 * @param action Either start or cancel.
	 * @param sha256 sha256 hash of the package.
	 * @param timeout (Optional) Limits upgrade time on each Node.
	 * @param schedule (Optional) Schedule of when to perform upgrade on each node. Map Node DIDs to upgrade time.
	 * @param justification (Optional) justification string for this particular Upgrade.
	 * @param reinstall Whether it's allowed to re-install the same version. False by default.
	 * @param force Whether we should apply transaction (schedule Upgrade) without waiting for consensus of this transaction.
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildPoolUpgradeRequest(
			String submitterDid,
			String name,
			String version,
			String action,
			String sha256,
			int timeout,
			String schedule,
			String justification,
			boolean reinstall,
			boolean force) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_pool_upgrade_request(
				commandHandle,
				submitterDid,
				name,
				version,
				action,
				sha256,
				timeout,
				schedule,
				justification,
				reinstall,
				force,
				buildPoolUpgradeRequestCb);

		checkResult(result);

		return future;
	}

	/**
	 * Builds a REVOC_REG_DEF request. Request to add the definition of revocation registry
	 * to an exists claim definition.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param type Revocation Registry type (only CL_ACCUM is supported for now).
	 * @param tag Unique descriptive ID of the Registry.
	 * @param credDefId ID of the corresponding ClaimDef.
	 * @param value Registry-specific data: {
	 *                 issuance_type: string - Type of Issuance(ISSUANCE_BY_DEFAULT or ISSUANCE_ON_DEMAND),
	 *                 max_cred_num: number - Maximum number of credentials the Registry can serve.
	 *                 public_keys: <public_keys> - Registry's public key.
	 *                 tails_hash: string - Hash of tails.
	 *                 tails_locaiton: string - Location of tails file.
	 *             }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildRevocRegDefRequest(
			String submitterDid,
			String type,
			String tag,
			String credDefId,
			String value) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_revoc_reg_def_request(
				commandHandle,
				submitterDid,
				type,
				tag,
				credDefId,
				value,
				buildRevocRegDefRequestCb);

		checkResult(result);

		return future;
	}


	/**
	 * Builds a REVOC_REG_ENTRY request.  Request to add the RevocReg entry containing
	 * the new accumulator value and issued/revoked indices.
	 * This is just a delta of indices, not the whole list.
	 * So, it can be sent each time a new claim is issued/revoked.
	 *
	 * @param submitterDid DID of the submitter stored in secured Wallet.
	 * @param type Revocation Registry type (only CL_ACCUM is supported for now).
	 * @param revocRegDefId ID of the corresponding RevocRegDef.
	 * @param value Registry-specific data: {
	 *                 issued: array<number> - an array of issued indices.
	 *                 revoked: array<number> an array of revoked indices.
	 *                 prev_accum: previous accumulator value.
	 *                 accum: current accumulator value.
     *             }
	 * @return A future resolving to a JSON request string.
	 * @throws IndyException Thrown if an error occurs when calling the underlying SDK.
	 */
	public static CompletableFuture<String> buildRevocRegDeltaRequest(
			String submitterDid,
			String type,
			String revocRegDefId,
			String value) throws IndyException {

		ParamGuard.notNullOrWhiteSpace(submitterDid, "submitterDid");

		CompletableFuture<String> future = new CompletableFuture<String>();
		int commandHandle = addFuture(future);

		int result = LibIndy.api.indy_build_revoc_reg_delta_request(
				commandHandle,
				submitterDid,
				type,
				revocRegDefId,
				value,
				buildRevocRegDeltaRequestCb);

		checkResult(result);

		return future;
	}
}

