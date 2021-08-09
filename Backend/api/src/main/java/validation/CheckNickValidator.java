package validation;

import ru.oogis.service.ShowAccountService;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CheckNickValidator implements ConstraintValidator<EnableMatchConstraint, ShowUser> {

    private final ShowAccountService showAccountService;

    public CheckNickValidator(ShowAccountService showAccountService) {
        this.showAccountService = showAccountService;
    }

    @Override
    public void initialize(final EnableMatchConstraint constraint) {
    }

    @Override
    public boolean isValid(final ShowUser user, ConstraintValidatorContext constraintValidatorContext) {

        Optional<ShowUserInfo> opt = showAccountService.checkUserByNick(user.getNick());
        if (opt.isEmpty()) return true;

        if (user.getId() != null) {

            ShowUserInfo userInfo = opt.get();
            return user.getId().equals(userInfo.getId());
        }

        return false;
    }
}
