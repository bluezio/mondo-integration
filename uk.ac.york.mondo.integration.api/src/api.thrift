namespace java uk.ac.york.mondo.integration.api

enum CommitItemChangeType {
		/* File was added. */ ADDED 
		/* File was removed. */ DELETED 
		/* File was removed. */ REPLACED 
		/* Unknown type of change. */ UNKNOWN 
		/* File was updated. */ UPDATED 
}

enum HawkState {
		/* The instance is running and monitoring the indexed locations. */ RUNNING 
		/* The instance is stopped and is not monitoring any indexed locations. */ STOPPED 
		/* The instance is updating its contents from the indexed locations. */ UPDATING 
}

enum IFCExportStatus {
		/* The job has been cancelled. */ CANCELLED 
		/* The job is completed. */ DONE 
		/* The job has failed. */ FAILED 
		/* The job is currently running. */ RUNNING 
		/* The job has been scheduled but has not started yet. */ SCHEDULED 
}

enum SubscriptionDurability {
		/* Subscription survives client disconnections but not server restarts. */ DEFAULT 
		/* Subscription survives client disconnections and server restarts. */ DURABLE 
		/* Subscription removed after disconnecting. */ TEMPORARY 
}

enum TransformationState {
		/* The transformation has failed. */ FAILED 
		/* The transformation was interrupted by a user (i.e. killed). */ KILLED 
		/* The transformation is in preparation. */ PREP 
		/* The transformation is running. */ RUNNING 
		/* The transformation has completed successfully. */ SUCCEEDED 
}


struct CommitItem {
	 /* URL of the repository. */ 1: required string repoURL,
	 /* Unique identifier of the revision of the repository. */ 2: required string revision,
	 /* Path within the repository, using / as separator. */ 3: required string path,
	 /* Type of change within the commit. */ 4: required CommitItemChangeType type,
}

struct Credentials {
	 /* Username for logging into the VCS. */ 1: required string username,
	 /* Password for logging into the VCS. */ 2: required string password,
}

struct DerivedAttributeSpec {
	 /* The URI of the metamodel to which the derived attribute belongs. */ 1: required string metamodelUri,
	 /* The name of the type to which the derived attribute belongs. */ 2: required string typeName,
	 /* The name of the derived attribute. */ 3: required string attributeName,
	 /* The (primitive) type of the derived attribute. */ 4: optional string attributeType,
	 /* The multiplicity of the derived attribute. */ 5: optional bool isMany,
	 /* A flag specifying whether the order of the values of the derived attribute is significant (only makes sense when isMany=true). */ 6: optional bool isOrdered,
	 /* A flag specifying whether the the values of the derived attribute are unique (only makes sense when isMany=true). */ 7: optional bool isUnique,
	 /* The language used to express the derivation logic. */ 8: optional string derivationLanguage,
	 /* An executable expression of the derivation logic in the language above. */ 9: optional string derivationLogic,
}

exception FailedQuery {
	 /* Reason for the query failing to complete its execution. */ 1: required string reason,
}

struct File {
	 /* Name of the file. */ 1: required string name,
	 /* Sequence of bytes with the contents of the file. */ 2: required binary contents,
}

exception GoldRepoNotFound {
}

struct HawkInstance {
	 /* The name of the instance. */ 1: required string name,
	 /* Current state of the instance. */ 2: required HawkState state,
	 /* Last info message from the instance. */ 3: required string message,
}

exception HawkInstanceNotFound {
}

exception HawkInstanceNotRunning {
}

struct HawkStateEvent {
	 /* Timestamp for this state change. */ 1: required i64 timestamp,
	 /* State of the Hawk instance. */ 2: required HawkState state,
	 /* Short message about the current status of the server. */ 3: required string message,
}

struct HawkSynchronizationEndEvent {
	 /* Local timestamp, measured in nanoseconds. Only meant to be used to compute synchronization cost. */ 1: required i64 timestampNanos,
}

struct HawkSynchronizationStartEvent {
	 /* Local timestamp, measured in nanoseconds. Only meant to be used to compute synchronization cost. */ 1: required i64 timestampNanos,
}

struct IFCExportJob {
	 /*  */ 1: required string jobID,
	 /*  */ 2: required IFCExportStatus status,
	 /*  */ 3: required string message,
}

struct IndexedAttributeSpec {
	 /* The URI of the metamodel to which the indexed attribute belongs. */ 1: required string metamodelUri,
	 /* The name of the type to which the indexed attribute belongs. */ 2: required string typeName,
	 /* The name of the indexed attribute. */ 3: required string attributeName,
}

exception InvalidDerivedAttributeSpec {
	 /* Reason for the spec not being valid. */ 1: required string reason,
}

exception InvalidIndexedAttributeSpec {
	 /* Reason for the spec not being valid. */ 1: required string reason,
}

exception InvalidMetamodel {
	 /* Reason for the metamodel not being valid. */ 1: required string reason,
}

exception InvalidPollingConfiguration {
	 /* Reason for the spec not being valid. */ 1: required string reason,
}

exception InvalidQuery {
	 /* Reason for the query not being valid. */ 1: required string reason,
}

exception InvalidTransformation {
	 /* Reason for the transformation not being valid. */ 1: required string reason,
	 /* Location of the problem, if applicable. Usually a combination of line and column numbers. */ 2: required string location,
}

union MixedReference {
	 /* Identifier-based reference to a model element. */ 1: optional string id,
	 /* Position-based reference to a model element. */ 2: optional i32 position,
}

struct ModelSpec {
	 /* The URI from which the model will be loaded or to which it will be persisted. */ 1: required string uri,
	 /* The URIs of the metamodels to which elements of the model conform. */ 2: required list<string> metamodelUris,
}

exception OfflineCollaborationInternalError {
	 /* Summary description of the error. See details in server log. */ 1: required string errorMessage,
}

struct Repository {
	 /* The URI to the repository. */ 1: required string uri,
	 /* The type of repository. */ 2: required string type,
	 /* True if the repository is frozen, false otherwise. */ 3: optional bool isFrozen = false,
}

struct Slot {
	 /* The name of the model element property the value of which is stored in this slot. */ 1: required string name,
}

struct SlotMetadata {
	 /* The name of the model element property that is stored in this slot. */ 1: required string name,
	 /* The type of the values in this slot. */ 2: required string type,
	 /* True if this slot holds a collection of values instead of a single value. */ 3: required bool isMany,
	 /* True if the values in this slot are ordered. */ 4: required bool isOrdered,
	 /* True if the value of this slot must be unique within its containing model. */ 5: required bool isUnique,
}

union SlotValue {
	 /* Boolean (true/false) value. */ 1: optional bool vBoolean,
	 /* 8-bit signed integer value. */ 2: optional byte vByte,
	 /* 16-bit signed integer value. */ 3: optional i16 vShort,
	 /* 32-bit signed integer value. */ 4: optional i32 vInteger,
	 /* 64-bit signed integer value. */ 5: optional i64 vLong,
	 /* 64-bit floating point value. */ 6: optional double vDouble,
	 /* Sequence of UTF8 characters. */ 7: optional string vString,
	 /* List of true/false values. */ 8: optional list<bool> vBooleans,
	 /* List of 8-bit signed integers. */ 9: optional binary vBytes,
	 /* List of 16-bit signed integers. */ 10: optional list<i16> vShorts,
	 /* List of 32-bit signed integers. */ 11: optional list<i32> vIntegers,
	 /* List of 64-bit signed integers. */ 12: optional list<i64> vLongs,
	 /* List of 64-bit floating point values. */ 13: optional list<double> vDoubles,
	 /* List of sequences of UTF8 characters. */ 14: optional list<string> vStrings,
}

struct Subscription {
	 /* Host name of the message queue server. */ 1: required string host,
	 /* Port in which the message queue server is listening. */ 2: required i32 port,
	 /* Address of the topic queue. */ 3: required string queueAddress,
	 /* Name of the topic queue. */ 4: required string queueName,
	 /* Whether SSL is required or not. */ 5: required bool sslRequired = false,
}

struct TransformationStatus {
	 /* State of the tranformation. */ 1: required TransformationState state,
	 /* Time passed since the start of execution, in milliseconds. */ 2: required i64 elapsed,
	 /* Description of the error that caused the transformation to fail. */ 3: required string error,
}

exception TransformationTokenNotFound {
	 /* Transformation token which was not found within the invoked MONDO instance. */ 1: required string token,
}

exception UnauthorizedRepositoryOperation {
}

exception UnknownQueryLanguage {
}

exception UnknownRepositoryType {
}

exception UserExists {
}

exception UserNotFound {
}

struct UserProfile {
	 /* The real name of the user. */ 1: required string realName,
	 /* Whether the user has admin rights (i.e. so that they can create new users, change the status of admin users etc). */ 2: required bool admin,
}

exception VCSAuthenticationFailed {
}

union Value {
	 /* Boolean (true/false) value. */ 1: optional bool vBoolean,
	 /* 8-bit signed integer value. */ 2: optional byte vByte,
	 /* 16-bit signed integer value. */ 3: optional i16 vShort,
	 /* 32-bit signed integer value. */ 4: optional i32 vInteger,
	 /* 64-bit signed integer value. */ 5: optional i64 vLong,
	 /* 64-bit floating point value. */ 6: optional double vDouble,
	 /* Sequence of UTF8 characters. */ 7: optional string vString,
}

struct AttributeSlot {
	 /* The name of the model element property the value of which is stored in this slot. */ 1: required string name,
	 /* Value of the slot (if set). */ 2: optional SlotValue value,
}

struct HawkAttributeRemovalEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Identifier of the model element that was changed. */ 2: required string id,
	 /* Name of the attribute that was removed. */ 3: required string attribute,
}

struct HawkAttributeUpdateEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Identifier of the model element that was changed. */ 2: required string id,
	 /* Name of the attribute that was changed. */ 3: required string attribute,
	 /* New value for the attribute. */ 4: required SlotValue value,
}

struct HawkFileAdditionEvent {
	 /* Reference to file that was added, including VCS metadata. */ 1: required CommitItem vcsItem,
}

struct HawkFileRemovalEvent {
	 /* Reference to file that was removed, including VCS metadata. */ 1: required CommitItem vcsItem,
}

struct HawkModelElementAdditionEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Metamodel URI of the type of the model element. */ 2: required string metamodelURI,
	 /* Name of the type of the model element. */ 3: required string typeName,
	 /* Identifier of the model element that was added. */ 4: required string id,
}

struct HawkModelElementRemovalEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Identifier of the model element that was removed. */ 2: required string id,
}

struct HawkReferenceAdditionEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Identifier of the source model element. */ 2: required string sourceId,
	 /* Identifier of the target model element. */ 3: required string targetId,
	 /* Name of the reference that was added. */ 4: required string refName,
}

struct HawkReferenceRemovalEvent {
	 /* Entry within the commit that produced the changes. */ 1: required CommitItem vcsItem,
	 /* Identifier of the source model element. */ 2: required string sourceId,
	 /* Identifier of the target model element. */ 3: required string targetId,
	 /* Name of the reference that was removed. */ 4: required string refName,
}

exception InvalidModelSpec {
	 /* A copy of the invalid model specification. */ 1: required ModelSpec spec,
	 /* Reason for the spec not being valid. */ 2: required string reason,
}

struct ModelElementType {
	 /* Unique ID of the model element type. */ 1: required string id,
	 /* URI of the metamodel to which the type belongs. */ 2: required string metamodelUri,
	 /* Name of the type. */ 3: required string typeName,
	 /* Metadata for the attribute slots. */ 4: optional list<SlotMetadata> attributes,
	 /* Metadata for the reference slots. */ 5: optional list<SlotMetadata> references,
}

struct ReferenceSlot {
	 /* The name of the model element property the value of which is stored in this slot. */ 1: required string name,
	 /* Position of the referenced element (if there is only one position-based reference in this slot). */ 2: optional i32 position,
	 /* Positions of the referenced elements (if more than one). */ 3: optional list<i32> positions,
	 /* Unique identifier of the referenced element (if there is only one ID based reference in this slot). */ 4: optional string id,
	 /* Unique identifiers of the referenced elements (if more than one). */ 5: optional list<string> ids,
	 /* Mix of identifier- and position-bsaed references (if there is at least one position and one ID). */ 6: optional list<MixedReference> mixed,
}

union HawkChangeEvent {
	 /* A model element was added. */ 1: optional HawkModelElementAdditionEvent modelElementAddition,
	 /* A model element was removed. */ 2: optional HawkModelElementRemovalEvent modelElementRemoval,
	 /* An attribute was updated. */ 3: optional HawkAttributeUpdateEvent modelElementAttributeUpdate,
	 /* An attribute was removed. */ 4: optional HawkAttributeRemovalEvent modelElementAttributeRemoval,
	 /* A reference was added. */ 5: optional HawkReferenceAdditionEvent referenceAddition,
	 /* A reference was removed. */ 6: optional HawkReferenceRemovalEvent referenceRemoval,
	 /* Synchronization started. */ 7: optional HawkSynchronizationStartEvent syncStart,
	 /* Synchronization ended. */ 8: optional HawkSynchronizationEndEvent syncEnd,
	 /* A file was added. */ 9: optional HawkFileAdditionEvent fileAddition,
	 /* A file was removed. */ 10: optional HawkFileRemovalEvent fileRemoval,
}

struct HawkQueryOptions {
	 /* The repository for the query (or * for all repositories). */ 1: optional string repositoryPattern = "*",
	 /* The file patterns for the query (e.g. *.uml). */ 2: optional list<string> filePatterns,
	 /* The default namespaces to be used to resolve ambiguous unqualified types. */ 3: optional string defaultNamespaces,
	 /* Whether to include attributes (true) or not (false) in model element results. */ 4: optional bool includeAttributes = true,
	 /* Whether to include references (true) or not (false) in model element results. */ 5: optional bool includeReferences = true,
	 /* Whether to include node IDs (true) or not (false) in model element results. */ 6: optional bool includeNodeIDs = false,
	 /* Whether to include all the child elements of the model element results (true) or not (false). */ 7: optional bool includeContained = true,
	 /* If set and not empty, only the specified metamodels, types and features will be fetched. Otherwise, everything that is not excluded will be fetched. The string '*' can be used to refer to all types within a metamodel or all fields within a type. */ 8: optional map<string,map<string,set<string>>> effectiveMetamodelIncludes,
	 /* If set and not empty, the mentioned metamodels, types and features will not be fetched. The string '*' can be used to refer to all types within a metamodel or all fields within a type. */ 9: optional map<string,map<string,set<string>>> effectiveMetamodelExcludes,
}

struct IFCExportOptions {
	 /* The repository for the query (or * for all repositories). */ 1: optional string repositoryPattern = "*",
	 /* The file patterns for the query (e.g. *.uml). */ 2: optional list<string> filePatterns,
	 /* If set and not empty, only the specified metamodels, types and features will be fetched. Otherwise, everything that is not excluded will be fetched. The string '*' can be used to refer to all types within a metamodel or all fields within a type. */ 3: optional map<string,map<string,set<string>>> includeRules,
	 /* If set and not empty, the mentioned metamodels, types and features will not be fetched. The string '*' can be used to refer to all types within a metamodel or all fields within a type. */ 4: optional map<string,map<string,set<string>>> excludeRules,
}

struct ModelElement {
	 /* Unique ID of the model element (not set if using position-based references). */ 1: optional string id,
	 /* URI of the repository to which the element belongs (not set if equal to that of the previous model element). */ 2: optional string repositoryURL,
	 /* Name of the file to which the element belongs (not set if equal to that of the previous model element). */ 3: optional string file,
	 /* URI of the metamodel to which the type of the element belongs (not set if equal to that of the previous model element). */ 4: optional string metamodelUri,
	 /* Name of the type that the model element is an instance of (not set if equal to that of the previous model element). */ 5: optional string typeName,
	 /* Slots holding the values of the model element's attributes, if any have been set. */ 6: optional list<AttributeSlot> attributes,
	 /* Slots holding the values of the model element's references, if any have been set. */ 7: optional list<ReferenceSlot> references,
	 /* Slots holding contained model elements, if any have been set. */ 8: optional list<ContainerSlot> containers,
}

struct ContainerSlot {
	 /* The name of the model element property the value of which is stored in this slot. */ 1: required string name,
	 /* Contained elements for this slot. */ 2: required list<ModelElement> elements,
}

union QueryResult {
	 /* Boolean (true/false) value. */ 1: optional bool vBoolean,
	 /* 8-bit signed integer value. */ 2: optional byte vByte,
	 /* 16-bit signed integer value. */ 3: optional i16 vShort,
	 /* 32-bit signed integer value. */ 4: optional i32 vInteger,
	 /* 64-bit signed integer value. */ 5: optional i64 vLong,
	 /* 64-bit floating point value. */ 6: optional double vDouble,
	 /* Sequence of UTF8 characters. */ 7: optional string vString,
	 /* Encoded model element. */ 8: optional ModelElement vModelElement,
	 /* Encoded model element type. */ 9: optional ModelElementType vModelElementType,
}

/* The majority of service operations provided by the MONDO
   		platform require user authentication (indicated in the top-left
   		cell of each operation table) to prevent unaccountable use.
   		As such, the platform needs to provide basic user management service operations
   		for creating, updating and deleting user accounts. */
service Users {
  /* Creates a new platform user. Auth needed: Yes */
  void createUser(
	/* A unique identifier for the user. */ 1: required string username,
	/* The desired password. */ 2: required string password,
	/* The profile of the user. */ 3: required UserProfile profile,
  )
  throws (
	1: UserExists err1 /* The specified username already exists. */ 
	) 
	
  /* Updates the profile of a platform user. Auth needed: Yes */
  void updateProfile(
	/* The name of the user to update the profile of. */ 1: required string username,
	/* The updated profile of the user. */ 2: required UserProfile profile,
  )
  throws (
	1: UserNotFound err1 /* The specified username does not exist. */ 
	) 
	
  /* Updates the password of a platform user. Auth needed: Yes */
  void updatePassword(
	/* The name of the user to update the profile of. */ 1: required string username,
	/* New password to be set. */ 2: required string newPassword,
  )
  throws (
	1: UserNotFound err1 /* The specified username does not exist. */ 
	) 
	
  /* Deletes a platform user. Auth needed: Yes */
  void deleteUser(
	/* The name of the user to delete. */ 1: required string username,
  )
  throws (
	1: UserNotFound err1 /* The specified username does not exist. */ 
	) 
	
}

/* The following service operations expose the capabilities of the Hawk heterogeneous model indexing
   framework developed in Work Package 5. The framework is discussed in detail in D5.2 and D5.3. */
service Hawk {
  /* Creates a new Hawk instance (stopped). Auth needed: Yes */
  void createInstance(
	/* The unique name of the new Hawk instance. */ 1: required string name,
	/* The name of the backend to be used, as returned by listBackends(). */ 2: required string backend,
	/* Minimum delay between periodic synchronization in milliseconds. */ 3: required i32 minimumDelayMillis,
	/* Maximum delay between periodic synchronization in milliseconds (0 to disable periodic synchronization). */ 4: required i32 maximumDelayMillis,
	/* List of plugins to be enabled: if not set, all plugins are enabled. */ 5:  list<string> enabledPlugins,
  )
	
  /* Lists the names of the available storage backends. Auth needed: Yes */
  list<string> listBackends(
  )
	
  /* Lists all the Hawk plugins that can be enabled or disabled: metamodel parsers, model parsers and graph change listeners. Auth needed: Yes */
  list<string> listPlugins(
  )
	
  /* Lists the details of all Hawk instances. Auth needed: Yes */
  list<HawkInstance> listInstances(
  )
	
  /* Removes an existing Hawk instance. Auth needed: Yes */
  void removeInstance(
	/* The name of the Hawk instance to remove. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	) 
	
  /* Starts a stopped Hawk instance. Auth needed: Yes */
  void startInstance(
	/* The name of the Hawk instance to start. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	) 
	
  /* Stops a running Hawk instance. Auth needed: Yes */
  void stopInstance(
	/* The name of the Hawk instance to stop. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Forces an immediate synchronization on a Hawk instance. Auth needed: Yes */
  void syncInstance(
	/* The name of the Hawk instance to stop. */ 1: required string name,
	/* If true, blocks the call until the synchronisation completes. False by default. */ 2:  bool blockUntilDone = false,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Registers a set of file-based metamodels with a Hawk instance. Auth needed: Yes */
  void registerMetamodels(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The metamodels to register.
	   			More than one metamodel file can be provided in one
	   			request, to accomodate fragmented metamodels. */ 2: required list<File> metamodel,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: InvalidMetamodel err2 /* The provided metamodel is not valid (e.g. unparsable or inconsistent). */ 
	3: HawkInstanceNotRunning err3 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Unregisters a metamodel from a Hawk instance. Auth needed: Yes */
  void unregisterMetamodels(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URIs of the metamodels. */ 2: required list<string> metamodel,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the URIs of the registered metamodels of a Hawk instance. Auth needed: Yes */
  list<string> listMetamodels(
	/* The name of the Hawk instance. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the supported query languages and their status. Auth needed: Yes */
  list<string> listQueryLanguages(
	/* The name of the Hawk instance. */ 1: required string name,
  )
	
  /* Runs a query on a Hawk instance and returns a sequence of scalar values and/or model elements. Auth needed: Yes */
  list<QueryResult> query(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The query to be executed. */ 2: required string query,
	/* The name of the query language used (e.g. EOL, OCL). */ 3: required string language,
	/* Options for the query. */ 4: required HawkQueryOptions options,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	3: UnknownQueryLanguage err3 /* The specified query language is not supported by the operation. */ 
	4: InvalidQuery err4 /* The specified query is not valid. */ 
	5: FailedQuery err5 /* The specified query failed to complete its execution. */ 
	) 
	
  /* Returns populated model elements for the provided proxies. Auth needed: Yes */
  list<ModelElement> resolveProxies(
	/* The name of the Hawk instance. */ 1: required string name,
	/* Proxy model element IDs to be resolved. */ 2: required list<string> ids,
	/* Options for the query. */ 3: required HawkQueryOptions options,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Asks a Hawk instance to start monitoring a repository. Auth needed: Yes */
  void addRepository(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The repository to monitor. */ 2: required Repository repo,
	/* A valid set of credentials that has read-access to the repository. */ 3:  Credentials credentials,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	3: UnknownRepositoryType err3 /* The specified repository type is not supported by the operation. */ 
	4: VCSAuthenticationFailed err4 /* The client failed to prove its identity in the VCS. */ 
	) 
	
  /* Returns true if a repository is frozen, false otherwise. Auth needed: Yes */
  bool isFrozen(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the repository to query. */ 2: required string uri,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Changes the 'frozen' state of a repository. Auth needed: Yes */
  void setFrozen(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the repository to be changed. */ 2: required string uri,
	/* Whether the repository should be frozen (true) or not (false). */ 3: required bool isFrozen,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Asks a Hawk instance to stop monitoring a repository and remove its elements from the graph. Auth needed: Yes */
  void removeRepository(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the repository to stop monitoring. */ 2: required string uri,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Changes the credentials used to monitor a repository. Auth needed: Yes */
  void updateRepositoryCredentials(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the repository to update. */ 2: required string uri,
	/* The new credentials to be used. */ 3: required Credentials cred,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the repositories monitored by a Hawk instance. Auth needed: Yes */
  list<Repository> listRepositories(
	/* The name of the Hawk instance. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the available repository types in this installation. Auth needed: Yes */
  list<string> listRepositoryTypes(
  )
	
  /* Lists the paths of the files of the indexed repository. Auth needed: Yes */
  list<string> listFiles(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the indexed repository. */ 2: required list<string> repository,
	/* File name patterns to search for (* lists all files). */ 3: required list<string> filePatterns,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Sets the base polling period and max interval of a Hawk instance. Auth needed: Yes */
  void configurePolling(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The base polling period (in seconds). */ 2: required i32 base,
	/* The maximum polling interval (in seconds). */ 3: required i32 max,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	3: InvalidPollingConfiguration err3 /* The polling configuration is not valid. */ 
	) 
	
  /* Add a new derived attribute to a Hawk instance. Auth needed: Yes */
  void addDerivedAttribute(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The details of the new derived attribute. */ 2: required DerivedAttributeSpec spec,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	3: InvalidDerivedAttributeSpec err3 /* The derived attribute specification is not valid. */ 
	) 
	
  /* Remove a derived attribute from a Hawk instance. Auth needed: Yes */
  void removeDerivedAttribute(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The details of the derived attribute to be removed.
	   			Only the first three fields of the spec
	   			need to be populated. */ 2: required DerivedAttributeSpec spec,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the derived attributes of a Hawk instance. Only the first three fields of the spec are currently populated. Auth needed: Yes */
  list<DerivedAttributeSpec> listDerivedAttributes(
	/* The name of the Hawk instance. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Add a new indexed attribute to a Hawk instance. Auth needed: Yes */
  void addIndexedAttribute(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The details of the new indexed attribute. */ 2: required IndexedAttributeSpec spec,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	3: InvalidIndexedAttributeSpec err3 /* The indexed attribute specification is not valid. */ 
	) 
	
  /* Remove a indexed attribute from a Hawk instance. Auth needed: Yes */
  void removeIndexedAttribute(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The details of the indexed attribute to be removed. */ 2: required IndexedAttributeSpec spec,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Lists the indexed attributes of a Hawk instance. Auth needed: Yes */
  list<IndexedAttributeSpec> listIndexedAttributes(
	/* The name of the Hawk instance. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Returns the contents of one or more models indexed in a Hawk instance. Cross-model references are also resolved, and contained objects are always sent. Auth needed: Yes */
  list<ModelElement> getModel(
	/* The name of the Hawk instance. */ 1: required string name,
	/* Options to limit the contents to be sent. */ 2: required HawkQueryOptions options,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Returns the root objects of one or more models indexed in a Hawk instance. Node IDs are always sent, and contained objects are never sent. Auth needed: Yes */
  list<ModelElement> getRootElements(
	/* The name of the Hawk instance. */ 1: required string name,
	/* Options to limit the contents to be sent. */ 2: required HawkQueryOptions options,
  )
	
  /* Returns subscription details to a queue of HawkStateEvents with notifications about changes in the indexer's state. Auth needed: Yes */
  Subscription watchStateChanges(
	/* The name of the Hawk instance. */ 1: required string name,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
  /* Returns subscription details to a queue of HawkChangeEvents with notifications about changes to a set of indexed models. Auth needed: Yes */
  Subscription watchModelChanges(
	/* The name of the Hawk instance. */ 1: required string name,
	/* The URI of the repository in which the model is contained. */ 2: required string repositoryUri,
	/* The pattern(s) for the model file(s) in the repository. */ 3: required list<string> filePath,
	/* Unique client ID (used as suffix for the queue name). */ 4: required string clientID,
	/* Durability of the subscription. */ 5: required SubscriptionDurability durableEvents,
  )
  throws (
	1: HawkInstanceNotFound err1 /* No Hawk instance exists with that name. */ 
	2: HawkInstanceNotRunning err2 /* The selected Hawk instance is not running. */ 
	) 
	
}

/* The offline collaboration tool is realized in the MONDO platform through the
   MONDO Offline Collaboration Server, as mentioned in D4.4~\cite{D4.4}. It extends an
   off-the-shelf version control server with ``hooks'' that enforce access control and
   maintain the lens relationship between the ``gold'' repository and the ``front'' repositories.
   This allows users to continue using their preferred tools for interacting with the version
   control systems in their day-to-day modelling activities. The access control rules to be used 
   by the security lens are themselves described in the repository.
   
   Nevertheless, managing the operation of the hooks and the lens relationship requires
   its own API, as this is not covered by traditional VCS protocols. The rest of the section
   describes an API for managing these access rules. */
service OfflineCollaboration {
  /* Retrieve the list of all managed gold repositories. Auth needed: Yes */
  list<string> listGoldRepositories(
  )
  throws (
	1: UnauthorizedRepositoryOperation err1 /* Authenticated user is not permitted to carry out the requested operation on the specified repository. */ 
	2: OfflineCollaborationInternalError err2 /* An internal error occurred on the collaboration server. See details in server log. */ 
	) 
	
  /* Regenerate all front repositories based on the gold repository. Requires superuser privileges. Auth needed: Yes */
  void regenerateFrontRepositories(
	/* URL of the gold repository. */ 1: required string goldRepoURL,
  )
  throws (
	1: GoldRepoNotFound err1 /* No gold repository is configured at the specified URL. */ 
	2: UnauthorizedRepositoryOperation err2 /* Authenticated user is not permitted to carry out the requested operation on the specified repository. */ 
	3: OfflineCollaborationInternalError err3 /* An internal error occurred on the collaboration server. See details in server log. */ 
	) 
	
  /* Retrieve the front repository URL for the current user. Auth needed: Yes */
  string getMyFrontRepositoryURL(
	/* URL of the gold repository. */ 1: required string goldRepoURL,
  )
  throws (
	1: GoldRepoNotFound err1 /* No gold repository is configured at the specified URL. */ 
	2: UnauthorizedRepositoryOperation err2 /* Authenticated user is not permitted to carry out the requested operation on the specified repository. */ 
	3: OfflineCollaborationInternalError err3 /* An internal error occurred on the collaboration server. See details in server log. */ 
	) 
	
  /* Retrieve the online collaboration access point URL for the current user. Auth needed: Yes */
  string getOnlineCollaborationURL(
	/* URL of the gold repository. */ 1: required string goldRepoURL,
  )
  throws (
	1: GoldRepoNotFound err1 /* No gold repository is configured at the specified URL. */ 
	2: UnauthorizedRepositoryOperation err2 /* Authenticated user is not permitted to carry out the requested operation on the specified repository. */ 
	3: OfflineCollaborationInternalError err3 /* An internal error occurred on the collaboration server. See details in server log. */ 
	) 
	
}

/* The following service operations expose the capabilities of the cloud-enabled
   version of the ATL transformation language which is presented in D3.3~\cite{D3.3}. */
service CloudATL {
  /* Invokes a cloud-based transformation in a batch non-blocking mode.
     			Returns a token that can be used to check the status of the transformation. Auth needed: Yes */
  string launch(
	/* The ATL source-code of the transformation. */ 1: required string transformation,
	/* The input models of the transformation. */ 2: required ModelSpec source,
	/* The target models of the transformation. */ 3: required ModelSpec target,
  )
  throws (
	1: InvalidTransformation err1 /* The transformation is not valid: it is unparsable or inconsistent. */ 
	2: InvalidModelSpec err2 /* The model specification is not valid: the model or the metamodels are inaccessible or invalid. */ 
	) 
	
  /* Lists the identifiers of the transformation jobs tracked by this server. Auth needed: Yes */
  list<string> getJobs(
  )
	
  /* Returns the status of a previously invoked transformation. Auth needed: Yes */
  TransformationStatus getStatus(
	/* A valid token returned by a previous call to launch(). */ 1: required string token,
  )
  throws (
	1: TransformationTokenNotFound err1 /* The specified transformation token does not exist within the invokved MONDO instance. */ 
	) 
	
  /* Kills a previously invoked transformation. Auth needed: Yes */
  void kill(
	/* A valid token returned by a previous call to launch(). */ 1: required string token,
  )
  throws (
	1: TransformationTokenNotFound err1 /* The specified transformation token does not exist within the invokved MONDO instance. */ 
	) 
	
}

/* IFC export facility for getting IFC models from MONDO server. */
service IFCExport {
  /* Export part of a Hawk index in IFC STEP format. Auth needed: Yes */
  IFCExportJob exportAsSTEP(
	/*  */ 1: required string hawkInstance,
	/*  */ 2: required IFCExportOptions options,
  )
	
  /* List all the previously scheduled IFC export jobs. Auth needed: Yes */
  list<IFCExportJob> getJobs(
  )
	
  /* Retrieve the current status of the job with the specified ID. Auth needed: Yes */
  IFCExportJob getJobStatus(
	/*  */ 1: required string jobID,
  )
	
  /* Cancel the job with the specified ID. Auth needed: Yes */
  bool killJob(
	/*  */ 1: required string jobID,
  )
	
}

