import {
  CHECK_REPEAT_PW,
} from './validate-rule';

export const PERSON_MODIFY_RULE = function () {
  return {
    newName: [
      {
        required: true,
        message: 'The user name cannot be empty',
        trigger: 'blur',
      },
    ],
    originPW: [
      {
        required: true,
        message: 'The original password cannot be empty',
        trigger: 'blur',
      },
      {
        type: 'string',
        min: 6,
        message: 'The password no less than 6 words',
        trigger: 'blur',
      },
    ],
    newPW: [
      {
        required: true,
        message: 'The new password cannot be empty',
        trigger: 'blur',
      },
      {
        type: 'string',
        min: 6,
        message: 'The password no less than 6 words',
        trigger: 'blur',
      },
    ],
    reNewPW: [
      {
        required: true,
        message: 'The repeat new password cannot be empty',
        trigger: 'blur',
      },
      {
        type: 'string',
        min: 6,
        message: 'The password no less than 6 words',
        trigger: 'blur',
      },
      {
        validator: CHECK_REPEAT_PW.bind(this),
        trigger: 'blur',
      },
    ],
  };
};
