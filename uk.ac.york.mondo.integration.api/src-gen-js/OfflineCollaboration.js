//
// Autogenerated by Thrift Compiler (0.9.3)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//


//HELPER FUNCTIONS AND STRUCTURES

OfflineCollaboration_addRule_args = function(args) {
  this.repoURL = null;
  this.rule = null;
  if (args) {
    if (args.repoURL !== undefined && args.repoURL !== null) {
      this.repoURL = args.repoURL;
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field repoURL is unset!');
    }
    if (args.rule !== undefined && args.rule !== null) {
      this.rule = new CollaborationRule(args.rule);
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field rule is unset!');
    }
  }
};
OfflineCollaboration_addRule_args.prototype = {};
OfflineCollaboration_addRule_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.repoURL = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRUCT) {
        this.rule = new CollaborationRule();
        this.rule.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_addRule_args.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_addRule_args');
  if (this.repoURL !== null && this.repoURL !== undefined) {
    output.writeFieldBegin('repoURL', Thrift.Type.STRING, 1);
    output.writeString(this.repoURL);
    output.writeFieldEnd();
  }
  if (this.rule !== null && this.rule !== undefined) {
    output.writeFieldBegin('rule', Thrift.Type.STRUCT, 2);
    this.rule.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_addRule_result = function(args) {
};
OfflineCollaboration_addRule_result.prototype = {};
OfflineCollaboration_addRule_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    input.skip(ftype);
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_addRule_result.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_addRule_result');
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_removeRule_args = function(args) {
  this.repoURL = null;
  this.ruleName = null;
  if (args) {
    if (args.repoURL !== undefined && args.repoURL !== null) {
      this.repoURL = args.repoURL;
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field repoURL is unset!');
    }
    if (args.ruleName !== undefined && args.ruleName !== null) {
      this.ruleName = args.ruleName;
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field ruleName is unset!');
    }
  }
};
OfflineCollaboration_removeRule_args.prototype = {};
OfflineCollaboration_removeRule_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.repoURL = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.ruleName = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_removeRule_args.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_removeRule_args');
  if (this.repoURL !== null && this.repoURL !== undefined) {
    output.writeFieldBegin('repoURL', Thrift.Type.STRING, 1);
    output.writeString(this.repoURL);
    output.writeFieldEnd();
  }
  if (this.ruleName !== null && this.ruleName !== undefined) {
    output.writeFieldBegin('ruleName', Thrift.Type.STRING, 2);
    output.writeString(this.ruleName);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_removeRule_result = function(args) {
  this.err1 = null;
  if (args instanceof CollaborationRuleNotFound) {
    this.err1 = args;
    return;
  }
  if (args) {
    if (args.err1 !== undefined && args.err1 !== null) {
      this.err1 = args.err1;
    }
  }
};
OfflineCollaboration_removeRule_result.prototype = {};
OfflineCollaboration_removeRule_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.err1 = new CollaborationRuleNotFound();
        this.err1.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_removeRule_result.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_removeRule_result');
  if (this.err1 !== null && this.err1 !== undefined) {
    output.writeFieldBegin('err1', Thrift.Type.STRUCT, 1);
    this.err1.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_updateRule_args = function(args) {
  this.repoURL = null;
  this.rule = null;
  if (args) {
    if (args.repoURL !== undefined && args.repoURL !== null) {
      this.repoURL = args.repoURL;
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field repoURL is unset!');
    }
    if (args.rule !== undefined && args.rule !== null) {
      this.rule = new CollaborationRule(args.rule);
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field rule is unset!');
    }
  }
};
OfflineCollaboration_updateRule_args.prototype = {};
OfflineCollaboration_updateRule_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.repoURL = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRUCT) {
        this.rule = new CollaborationRule();
        this.rule.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_updateRule_args.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_updateRule_args');
  if (this.repoURL !== null && this.repoURL !== undefined) {
    output.writeFieldBegin('repoURL', Thrift.Type.STRING, 1);
    output.writeString(this.repoURL);
    output.writeFieldEnd();
  }
  if (this.rule !== null && this.rule !== undefined) {
    output.writeFieldBegin('rule', Thrift.Type.STRUCT, 2);
    this.rule.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_updateRule_result = function(args) {
  this.err1 = null;
  if (args instanceof CollaborationRuleNotFound) {
    this.err1 = args;
    return;
  }
  if (args) {
    if (args.err1 !== undefined && args.err1 !== null) {
      this.err1 = args.err1;
    }
  }
};
OfflineCollaboration_updateRule_result.prototype = {};
OfflineCollaboration_updateRule_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.err1 = new CollaborationRuleNotFound();
        this.err1.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_updateRule_result.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_updateRule_result');
  if (this.err1 !== null && this.err1 !== undefined) {
    output.writeFieldBegin('err1', Thrift.Type.STRUCT, 1);
    this.err1.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_listRules_args = function(args) {
  this.repoURL = null;
  if (args) {
    if (args.repoURL !== undefined && args.repoURL !== null) {
      this.repoURL = args.repoURL;
    } else {
      throw new Thrift.TProtocolException(Thrift.TProtocolExceptionType.UNKNOWN, 'Required field repoURL is unset!');
    }
  }
};
OfflineCollaboration_listRules_args.prototype = {};
OfflineCollaboration_listRules_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.repoURL = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_listRules_args.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_listRules_args');
  if (this.repoURL !== null && this.repoURL !== undefined) {
    output.writeFieldBegin('repoURL', Thrift.Type.STRING, 1);
    output.writeString(this.repoURL);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaboration_listRules_result = function(args) {
  this.success = null;
  if (args) {
    if (args.success !== undefined && args.success !== null) {
      this.success = Thrift.copyList(args.success, [CollaborationRule]);
    }
  }
};
OfflineCollaboration_listRules_result.prototype = {};
OfflineCollaboration_listRules_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 0:
      if (ftype == Thrift.Type.LIST) {
        var _size288 = 0;
        var _rtmp3292;
        this.success = [];
        var _etype291 = 0;
        _rtmp3292 = input.readListBegin();
        _etype291 = _rtmp3292.etype;
        _size288 = _rtmp3292.size;
        for (var _i293 = 0; _i293 < _size288; ++_i293)
        {
          var elem294 = null;
          elem294 = new CollaborationRule();
          elem294.read(input);
          this.success.push(elem294);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

OfflineCollaboration_listRules_result.prototype.write = function(output) {
  output.writeStructBegin('OfflineCollaboration_listRules_result');
  if (this.success !== null && this.success !== undefined) {
    output.writeFieldBegin('success', Thrift.Type.LIST, 0);
    output.writeListBegin(Thrift.Type.STRUCT, this.success.length);
    for (var iter295 in this.success)
    {
      if (this.success.hasOwnProperty(iter295))
      {
        iter295 = this.success[iter295];
        iter295.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

OfflineCollaborationClient = function(input, output) {
    this.input = input;
    this.output = (!output) ? input : output;
    this.seqid = 0;
};
OfflineCollaborationClient.prototype = {};
OfflineCollaborationClient.prototype.addRule = function(repoURL, rule, callback) {
  this.send_addRule(repoURL, rule, callback); 
  if (!callback) {
  this.recv_addRule();
  }
};

OfflineCollaborationClient.prototype.send_addRule = function(repoURL, rule, callback) {
  this.output.writeMessageBegin('addRule', Thrift.MessageType.CALL, this.seqid);
  var args = new OfflineCollaboration_addRule_args();
  args.repoURL = repoURL;
  args.rule = rule;
  args.write(this.output);
  this.output.writeMessageEnd();
  if (callback) {
    var self = this;
    this.output.getTransport().flush(true, function() {
      var result = null;
      try {
        result = self.recv_addRule();
      } catch (e) {
        result = e;
      }
      callback(result);
    });
  } else {
    return this.output.getTransport().flush();
  }
};

OfflineCollaborationClient.prototype.recv_addRule = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new OfflineCollaboration_addRule_result();
  result.read(this.input);
  this.input.readMessageEnd();

  return;
};
OfflineCollaborationClient.prototype.removeRule = function(repoURL, ruleName, callback) {
  this.send_removeRule(repoURL, ruleName, callback); 
  if (!callback) {
  this.recv_removeRule();
  }
};

OfflineCollaborationClient.prototype.send_removeRule = function(repoURL, ruleName, callback) {
  this.output.writeMessageBegin('removeRule', Thrift.MessageType.CALL, this.seqid);
  var args = new OfflineCollaboration_removeRule_args();
  args.repoURL = repoURL;
  args.ruleName = ruleName;
  args.write(this.output);
  this.output.writeMessageEnd();
  if (callback) {
    var self = this;
    this.output.getTransport().flush(true, function() {
      var result = null;
      try {
        result = self.recv_removeRule();
      } catch (e) {
        result = e;
      }
      callback(result);
    });
  } else {
    return this.output.getTransport().flush();
  }
};

OfflineCollaborationClient.prototype.recv_removeRule = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new OfflineCollaboration_removeRule_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.err1) {
    throw result.err1;
  }
  return;
};
OfflineCollaborationClient.prototype.updateRule = function(repoURL, rule, callback) {
  this.send_updateRule(repoURL, rule, callback); 
  if (!callback) {
  this.recv_updateRule();
  }
};

OfflineCollaborationClient.prototype.send_updateRule = function(repoURL, rule, callback) {
  this.output.writeMessageBegin('updateRule', Thrift.MessageType.CALL, this.seqid);
  var args = new OfflineCollaboration_updateRule_args();
  args.repoURL = repoURL;
  args.rule = rule;
  args.write(this.output);
  this.output.writeMessageEnd();
  if (callback) {
    var self = this;
    this.output.getTransport().flush(true, function() {
      var result = null;
      try {
        result = self.recv_updateRule();
      } catch (e) {
        result = e;
      }
      callback(result);
    });
  } else {
    return this.output.getTransport().flush();
  }
};

OfflineCollaborationClient.prototype.recv_updateRule = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new OfflineCollaboration_updateRule_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.err1) {
    throw result.err1;
  }
  return;
};
OfflineCollaborationClient.prototype.listRules = function(repoURL, callback) {
  this.send_listRules(repoURL, callback); 
  if (!callback) {
    return this.recv_listRules();
  }
};

OfflineCollaborationClient.prototype.send_listRules = function(repoURL, callback) {
  this.output.writeMessageBegin('listRules', Thrift.MessageType.CALL, this.seqid);
  var args = new OfflineCollaboration_listRules_args();
  args.repoURL = repoURL;
  args.write(this.output);
  this.output.writeMessageEnd();
  if (callback) {
    var self = this;
    this.output.getTransport().flush(true, function() {
      var result = null;
      try {
        result = self.recv_listRules();
      } catch (e) {
        result = e;
      }
      callback(result);
    });
  } else {
    return this.output.getTransport().flush();
  }
};

OfflineCollaborationClient.prototype.recv_listRules = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new OfflineCollaboration_listRules_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.success) {
    return result.success;
  }
  throw 'listRules failed: unknown result';
};
