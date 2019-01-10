export const CHECK_REPEAT_PW = async function (rule, value, callback) {
  if (this.userForm['newPW'] !== value) {
    return callback(new Error('Two input password must be consistent'));
  } else {
    callback();
  }
};
